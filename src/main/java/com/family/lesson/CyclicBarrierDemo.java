package com.family.lesson;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Q_先森 on 2017/12/12.
 */
public class CyclicBarrierDemo {

    /**
     * CyclicBarrier 可循环障碍物(多线程计算之后,最后合并结果)
     * @param args
     */
    public static void main(String[] args) {
        // 3个人
        final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("人全了,先拍照留念");
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            final int user = i + 1;
            Runnable r = new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(user + "到达地点,当前已有" + (cb.getNumberWaiting() + 1));
                        // 阻塞
                        cb.await();
                        System.out.println("拍完照,开始吃饭");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(user + "吃完饭回家");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                }
            };
            executorService.execute(r);
        }
        executorService.shutdown();
    }
}
