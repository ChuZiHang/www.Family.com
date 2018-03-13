package com.family.lesson;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Q_先森 on 2017/12/12.
 */
public class ExchangerDemo {

    /**
     * Exchanger 两个线程进行数据交换
     *  1.校对工作
     * @param args
     */
    public static void main(String[] args) {
        // 交换器,交换String类型数据
        Exchanger<String> ec = new Exchanger<>();

        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String resultStr = ec.exchange("小乔");
                    System.out.println("用小乔换大乔===="+resultStr);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String resultStr = ec.exchange("大乔");
                    System.out.println("用大乔换小乔===="+resultStr);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.shutdown();
    }

}
