package com.family.thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * await()和signal()，即线程锁的方式
 * Created by Q_先森 on 2018/3/21.
 */
public class ProducerConsumerDemo2 {
    private LinkedList<Object> myList = new LinkedList<Object>();
    private int MAX = 10;
    private final Lock lock = new ReentrantLock();
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();

    public ProducerConsumerDemo2() {
    }

    public void start() {
        new Producer().start();
        new Consumer().start();
    }

    public static void main(String[] args) throws Exception {
        ProducerConsumerDemo2 s2 = new ProducerConsumerDemo2();
        s2.start();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (myList.size() == MAX) {
                        System.out.println("warning: it's full!");
                        full.await();
                    }
                    Object o = new Object();
                    if (myList.add(o)) {
                        System.out.println("Producer: " + o);
                        empty.signal();
                    }
                } catch (InterruptedException ie) {
                    System.out.println("producer is interrupted!");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (myList.size() == 0) {
                        System.out.println("warning: it's empty!");
                        empty.await();
                    }
                    Object o = myList.removeLast();
                    System.out.println("Consumer: " + o);
                    full.signal();
                } catch (InterruptedException ie) {
                    System.out.println("consumer is interrupted!");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
