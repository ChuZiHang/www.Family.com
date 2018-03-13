package com.family.lesson;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Q_先森 on 2017/12/12.
 */
public class DelayQueueDemo {
    /**
     * 这个场景中几个点需要注意：

     1.考试时间为120分钟，30分钟后才可交卷，初始化考生完成试卷时间最小应为30分钟
     2.对于能够在120分钟内交卷的考生，如何实现这些考生交卷
     3.对于120分钟内没有完成考试的考生，在120分钟考试时间到后需要让他们强制交卷
     4.在所有的考生都交完卷后，需要将控制线程关闭

     实现思想：用DelayQueue存储考生（Student类），每一个考生都有自己的名字和完成试卷的时间，
     Teacher线程对DelayQueue进行监控，收取完成试卷小于120分钟的学生的试卷。当考试时间120分钟到时，
     先关闭Teacher线程，然后强制DelayQueue中还存在的考生交卷。每一个考生交卷都会进行一次countDownLatch.countDown()，
     当countDownLatch.await()不再阻塞说明所有考生都交完卷了，而后结束考试。
     */

    class Student implements Runnable, Delayed {
        private String name; // 学生姓名
        private long workTime; // 希望用时
        private long submitTime; // 交卷时间
        private boolean isForce = false; // 是否强制
        private CountDownLatch countDownLatch; // 倒计时执行器

        public Student() {
        }
        // System.nanoTime()返回最准确的可用系统计时器的当前值，以毫微秒为单位。
        public Student(String name, long workTime, CountDownLatch countDownLatch) {
            this.name = name;
            this.workTime = workTime;
            this.submitTime = TimeUnit.NANOSECONDS.convert(workTime, TimeUnit.NANOSECONDS) + System.nanoTime();
            this.countDownLatch = countDownLatch;
        }

        // Delayed，一种混合风格的接口，用来标记那些应该在给定延迟时间之后执行的对象。
        // 此接口的实现必须定义一个 compareTo 方法，该方法提供与此接口的 getDelay 方法一致的排序。
        // 如果元素的getDelay()方法返回0或者小于0的时候才能将其出列.
        // 这个方法需要返回对象过期前的countdown时间。简单说，队列在某些方法处理前，会调用此方法来判断对象有没有超时。
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(submitTime - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (o == null || !(o instanceof Student)) return 1;
            if (o == this) return 0;
            Student s = (Student) o;
            if (this.workTime > s.workTime) {
                return 1;
            } else if (this.workTime == s.workTime) {
                return 0;
            } else {
                return -1;
            }
        }

        @Override
        public void run() {
            if (isForce) {
                System.out.println(name + " 交卷, 希望用时" + workTime + "分钟" + " ,实际用时 120分钟");
            } else {
                System.out.println(name + " 交卷, 希望用时" + workTime + "分钟" + " ,实际用时 " + workTime + " 分钟");
            }
            // countDown方法，当前线程调用此方法，则计数减一
            countDownLatch.countDown();
        }

        public boolean isForce() {
            return isForce;
        }

        public void setForce(boolean isForce) {
            this.isForce = isForce;
        }
    }

    class EndExam extends Student {
        private DelayQueue<Student> students;
        private CountDownLatch countDownLatch;
        private Thread teacherThread;

        public EndExam(DelayQueue<Student> students, long workTime, CountDownLatch countDownLatch, Thread teacherThread) {
            super("强制收卷", workTime, countDownLatch);
            this.students = students;
            this.countDownLatch = countDownLatch;
            this.teacherThread = teacherThread;
        }

        @Override
        public void run() {
            // 中断线程
            teacherThread.interrupt();
            Student tmpStudent;
            for (Iterator<Student> iterator2 = students.iterator(); iterator2.hasNext(); ) {
                tmpStudent = iterator2.next();
                tmpStudent.setForce(true);
                tmpStudent.run();
            }
            // countDown方法，当前线程调用此方法，则计数减一
            countDownLatch.countDown();
        }
    }

    class Teacher implements Runnable {
        private DelayQueue<Student> students;

        public Teacher(DelayQueue<Student> students) {
            this.students = students;
        }

        @Override
        public void run() {
            try {
                // 开始考试
                System.out.println(" test start");
                while (!Thread.interrupted()) {
                    students.take().run();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void excutor() throws InterruptedException {
        // 定义学生个数
        int studentNumber = 20;
        // 倒计时执行器
        CountDownLatch countDownLatch = new CountDownLatch(studentNumber + 1);
        // 延迟队列
        DelayQueue<Student> students = new DelayQueue<>();
        Random random = new Random();
        for (int i = 0; i < studentNumber; i++) {
            // 加入队列
            students.put(new Student("student" + (i + 1), 30 + random.nextInt(120), countDownLatch));
        }
        // 开始考试
        Thread teacherThread = new Thread(new Teacher(students));
        students.put(new EndExam(students, 120, countDownLatch, teacherThread));
        teacherThread.start();
        countDownLatch.await();
        System.out.println(" 考试时间到，全部交卷！");
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueueDemo dqd = new DelayQueueDemo();
        dqd.excutor();

    }


}
