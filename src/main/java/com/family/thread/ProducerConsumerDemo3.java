package com.family.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Q_先森 on 2018/3/21.
 */
public class ProducerConsumerDemo3 {
    /**
     * 建立一个阻塞队列
     */
    private LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(10);

    public ProducerConsumerDemo3() {
    }

    public void start() {
        new Producer().start();
        new Consumer().start();
    }

    public static void main(String[] args) throws Exception {
        ProducerConsumerDemo3 s3 = new ProducerConsumerDemo3();
        s3.start();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Object o = new Object();
                    // 放出一个对象
                    queue.put(o);
                    System.out.println("Producer: " + o);
                    Thread.sleep((long) (Math.random() * 3000));
                } catch (InterruptedException e) {
                    System.out.println("producer is interrupted!");
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    // 取出一个对象
                    Object o = queue.take();
                    System.out.println("Consumer: " + o);
                    Thread.sleep((long) (Math.random() * 3000));
                } catch (InterruptedException e) {
                    System.out.println("producer is interrupted!");
                }
            }
        }
    }
}
