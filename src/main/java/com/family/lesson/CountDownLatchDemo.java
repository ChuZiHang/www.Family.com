package com.family.lesson;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Q_先森 on 2017/12/12.
 */
public class CountDownLatchDemo {

    /**
     * CountDownLatch 倒计时执行器
     * @param args
     */
    public static void main(String[] args) {

        final CountDownLatch cdl = new CountDownLatch(2);
        // 任务1
        new Thread(){
            public void run() {
                try {
                    System.out.println("任务1正在执行任务!");
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("任务1执行完成!");
                    cdl.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        // 任务2
        new Thread(){
            public void run() {
                try {
                    System.out.println("任务2正在执行任务!");
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("任务2执行完成!");
                    cdl.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        System.out.println("等他俩搞定,我在上:"+Thread.currentThread().getName());

        try {
            cdl.await();
            System.out.println("等他俩搞定,我上了.......................");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
