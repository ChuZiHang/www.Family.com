package com.family.thread;

import java.util.Calendar;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Q_先森 on 2017/12/15.
 */
public class DelayQueueDemo2 {

    /**
     * 根据整理:http://blog.csdn.net/yjl49/article/details/7088121
     *  DelayQueue----一种有序队列，特点就是只有在队列中的元素到期后才能取出。
         1.内存中哪些对象到了超时时间，需要从内存中清除出去。
         2.服务器连接中有哪些连接很长时间未操作，需要关闭这些连接
         3.任务中有哪些到了执行时间，该进行调度了。
         简单的方法就是写一个线程不断去检查每一项是否到了时间，但这种方法在队列中的元素非常多的情况下会不准确或太耗费性能，用DelayQueue可完美地解决这个问题。

         马上就要过年了，每次回老家都要悲催地去镇上人挤人的网吧上网。下面就拿这个做个例子：
         假设镇上开了一家无限大的网吧，每人交一块钱可以上一分钟网(过年时的网吧坑爹程度差不多就这样)；
         网吧比较老式没有先进的管理系统，为了知道哪个家伙时间到该下机了，老板得一台一台地去看，上网的人一多等老板把整个网吧转一遍有些家伙早超时了，而且老板要一遍一遍地检查也累个半死；
         有一天某个人给老板开发了个简单的程序，这个程序可以自动将上机的人排序，并在恰当的时间告诉老板哪个家伙时间到了。这个程序大概会是这样：
     */

    // 网管
    class Webmaster implements Runnable {
        private DelayQueue<Customer> customers;

        public Webmaster(DelayQueue<Customer> customers) {
            this.customers = customers;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("检查.....");
                try {
                    customers.take().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 顾客
    class Customer implements Delayed, Runnable {
        // 身份证号
        private Integer id;
        // 姓名
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        // 下机时间 一元一秒
        private long endTime;

        // 以毫秒为单位
        public Customer(Integer id, String name, Integer money) {
            this.id = id;
            this.name = name;
            this.endTime = money * 1000 + System.currentTimeMillis();
        }

        // 设置优先级
        @Override
        public int compareTo(Delayed o) {
            Customer c = (Customer) o;
            return this.endTime - c.endTime > 0 ? 1 : (this.endTime - c.endTime < 0 ? -1 : 0);
        }

        // 判断过期时间
        @Override
        public long getDelay(TimeUnit unit) {

            return this.endTime - System.currentTimeMillis();
        }


        @Override
        public void run() {
            System.out.println("身份证：" + id + "姓名：" + name + "下机");
        }
    }

    private void excutor() throws InterruptedException {

        // 没有写计时器,,所以会一直检测

        System.out.println("开始营业-------------");
        DelayQueue<Customer> customers = new DelayQueue<>();

        customers.put(new Customer(123, "张三", 3));
        System.out.println("身份证：" + 123 + "姓名：" + "张三" + "上机时间" + "3");
        customers.put(new Customer(125, "李四", 5));
        System.out.println("身份证：" + 125 + "姓名：" + "李四" + "上机时间" + "5");
        customers.put(new Customer(189, "网五", 20));
        System.out.println("身份证：" + 189 + "姓名：" + "网五" + "上机时间" + "20");

        Thread teacherThread = new Thread(new Webmaster(customers));
        teacherThread.start();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Calendar.getInstance().get(Calendar.SECOND));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueueDemo2 delayQueueDemo = new DelayQueueDemo2();
        delayQueueDemo.excutor();
    }
}
