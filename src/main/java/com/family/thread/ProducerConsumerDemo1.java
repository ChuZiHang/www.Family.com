package com.family.thread;

import java.util.LinkedList;

/**
 * wait()和notify()
 * Created by Q_先森 on 2018/3/21.
 */
public class ProducerConsumerDemo1 {
    private LinkedList<Object> storeHouse = new LinkedList<>();
    private int MAX = 10;

    public ProducerConsumerDemo1() {
    }

    public void start() {
        new Producer().start();
        new Comsumer().start();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (storeHouse) {
                    try {
                        while (storeHouse.size() == MAX) {
                            System.out.println("storeHouse is full , please wait");
                            storeHouse.wait();
                        }
                        Object newOb = new Object();
                        if (storeHouse.add(newOb)) {
                            System.out.println("Producer put a Object to storeHouse");
                            Thread.sleep((long) (Math.random() * 3000));
                            storeHouse.notify();
                        }
                    } catch (InterruptedException ie) {
                        System.out.println("producer is interrupted!");
                    }

                }
            }
        }
    }

    class Comsumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (storeHouse) {
                    try {
                        while (storeHouse.size() == 0) {
                            System.out.println("storeHouse is empty , please wait");
                            storeHouse.wait();
                        }
                        storeHouse.removeLast();
                        System.out.println("Comsumer get  a Object from storeHouse");
                        Thread.sleep((long) (Math.random() * 3000));
                        storeHouse.notify();
                    } catch (InterruptedException ie) {
                        System.out.println("Consumer is interrupted");
                    }

                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        ProducerConsumerDemo1 pc = new ProducerConsumerDemo1();
        pc.start();
    }


}
