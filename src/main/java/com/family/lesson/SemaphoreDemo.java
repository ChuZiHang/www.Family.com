package com.family.lesson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Q_先森 on 2017/12/12.
 */
public class SemaphoreDemo {
    /**
     * Semaphore 信号量(控制并发线程数)
     */

    /**
     * 执行任务类,获取信号量和释放信号量
     */
    class SemaphoreRunnable implements Runnable {
        private Semaphore semaphore;

        private int user; // 记录第几个用户

        public SemaphoreRunnable(Semaphore semaphore, int user) {
            this.semaphore = semaphore;
            this.user = user;
        }

        @Override
        public void run() {
            try {
                // 获取信号量的许可
                semaphore.acquire();
                System.out.println("当前用户:" + user + "进入窗口,准备买票....");
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("当前用户:" + user + "买票完成,即将离开...");
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("当前用户:" + user + "离开窗口...");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 20个人,两个窗口买票
     */
    private void execut() {
        // 定义窗口数量
        final Semaphore semaphore = new Semaphore(2);
        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 模拟20个用户
        for (int i = 0; i < 20; i++) {
            // 执行买票
            executorService.execute(new SemaphoreRunnable(semaphore, (i + 1)));
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        SemaphoreDemo sd = new SemaphoreDemo();
        sd.execut();
    }
}
