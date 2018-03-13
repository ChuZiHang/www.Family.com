package com.family.Test;

/**
 * Created by Q_先森 on 2017/12/11.
 */
public class VolatileReview {

    public volatile static int count = 0;

    private static void test1(){}

    public static void main(String[] args) {
        // 开启十个线程
        for (int i = 0; i < 10; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            // 每个线程当中让count自增100次
                            for (int j = 0; j < 100; j++) {
                                count++; /// 不是原子性
                            }
                        }
                    }
            ).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count=======" + count);
    }
}
