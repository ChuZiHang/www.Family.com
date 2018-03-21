package com.family.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created by Q_先森 on 2017/12/12.
 */
public class CountDownLatchDemo {

    /**
     * CountDownLatch 倒计时执行器
     *
     * @param args
     */
    public static void main(String[] args) {

        final CountDownLatch cdl = new CountDownLatch(2);

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool1 = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        ExecutorService singleThreadPool2 = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("任务1正在执行任务!");
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("任务1执行完成!");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    cdl.countDown();
                }
            }
        });
        singleThreadPool2.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("任务2正在执行任务!");
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("任务2执行完成!");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    cdl.countDown();
                }
            }
        });

        // 任务1
        //        new Thread(){
        //            public void run() {
        //                try {
        //                    System.out.println("任务1正在执行任务!");
        //                    Thread.sleep((long) (Math.random() * 10000));
        //                    System.out.println("任务1执行完成!");
        //
        //                } catch (InterruptedException e) {
        //                    e.printStackTrace();
        //                }finally {
        //                    cdl.countDown();
        //                }
        //            }
        //        }.start();
        //        // 任务2
        //        new Thread(){
        //            public void run() {
        //                try {
        //                    System.out.println("任务2正在执行任务!");
        //                    Thread.sleep((long) (Math.random() * 10000));
        //                    System.out.println("任务2执行完成!");
        //                    cdl.countDown();
        //                } catch (InterruptedException e) {
        //                    e.printStackTrace();
        //                }
        //            }
        //        }.start();

        System.out.println("等他俩搞定,我在上:" + Thread.currentThread().getName());

        try {
            cdl.await();
            System.out.println("等他俩搞定,我上了.......................");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        singleThreadPool1.shutdown();
        singleThreadPool2.shutdown();
    }
}
