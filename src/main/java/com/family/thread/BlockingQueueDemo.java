package com.family.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Q_先森 on 2017/12/12.
 */
public class BlockingQueueDemo {
    /**
     * BlockingQueue 通常用于一个线程生产对象，而另外一个线程消费这些对象的场景
     * 一个线程将会持续生产新对象并将其插入到队列之中，直到队列达到它所能容纳的临界点。
     * 也就是说，它是有限的。如果该阻塞队列到达了其临界点，负责生产的线程将会在往里边插入新对象时发生阻塞。
     * 它会一直处于阻塞之中，直到负责消费的线程从队列中拿走一个对象。
     * 负责消费的线程将会一直从该阻塞队列中拿出对象。如果消费线程尝试去从一个空的队列中提取对象的话，
     * 这个消费线程将会处于阻塞之中，直到一个生产线程把一个对象丢进队列。
     */

    /**
     * 注意它在每次 put() 调用时是如何休眠一秒钟的。这将导致 Consumer 在等待队列中对象的时候发生阻塞。
     */
    class Producer implements Runnable {
        protected BlockingQueue queue = null;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                queue.put("1");
                System.out.println("弄了一个1进去");
                Thread.sleep(1000);
                queue.put("2");
                System.out.println("弄了一个2进去");
                Thread.sleep(1000);
                queue.put("3");
                System.out.println("弄了一个3进去");
                Thread.sleep(1000);
                System.out.println("搞定了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  Consumer 类。它只是把对象从队列中抽取出来，然后将它们打印到 System.out。
     */
    class Consumer implements Runnable {

        protected BlockingQueue queue = null;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                System.out.println(queue.take());
                System.out.println("这是1?");
                System.out.println(queue.take());
                System.out.println("这是2?");
                System.out.println(queue.take());
                System.out.println("这是3?");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void execut() {
        BlockingQueue queue = new ArrayBlockingQueue(1024);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingQueueDemo bqd= new BlockingQueueDemo();
        bqd.execut();

    }
}
