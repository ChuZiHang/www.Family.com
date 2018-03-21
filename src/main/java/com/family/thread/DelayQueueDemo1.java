package com.family.thread;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Q_先森 on 2017/12/15.
 * https://www.cnblogs.com/sunzhenchao/p/3515085.html
 */
public class DelayQueueDemo1<K, V> {

    public ConcurrentHashMap<K, V> map = new ConcurrentHashMap<>();

    public DelayQueue<DelayedItem<K>> queue = new DelayQueue<>();

    public void put(K k, V v, long liveTime) {
        V v2 = map.put(k, v);
        DelayedItem<K> tmpItem = new DelayedItem<>(k, liveTime);
        if (v2 != null) {
            queue.remove(tmpItem);
        }
        queue.put(tmpItem);
    }

    public DelayQueueDemo1() {
        Thread t = new Thread() {
            @Override
            public void run() {
                dameonCheckOverdueKey();
            }
        };
        t.setDaemon(true);
        t.start();
    }

    public void dameonCheckOverdueKey() {
        while (true) {
            DelayedItem<K> delayedItem = queue.poll();
            if (delayedItem != null) {
                map.remove(delayedItem.getT());
                System.out.println(System.nanoTime() + " remove " + delayedItem.getT() + " from cache");
            }
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class DelayedItem<T> implements Delayed {

        private T t;
        private long liveTime;
        private long removeTime;

        public DelayedItem(T t, long liveTime) {
            this.setT(t);
            this.liveTime = liveTime;
            this.removeTime = TimeUnit.NANOSECONDS.convert(liveTime, TimeUnit.NANOSECONDS) + System.nanoTime();
        }

        @Override
        public int compareTo(Delayed o) {
            if (o == null) return 1;
            if (o == this) return 0;
            if (o instanceof DelayedItem) {
                DelayedItem<T> tmpDelayedItem = (DelayedItem<T>) o;
                if (liveTime > tmpDelayedItem.liveTime) {
                    return 1;
                } else if (liveTime == tmpDelayedItem.liveTime) {
                    return 0;
                } else {
                    return -1;
                }
            }
            long diff = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
            return diff > 0 ? 1 : diff == 0 ? 0 : -1;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(removeTime - System.nanoTime(), unit);
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        @Override
        public int hashCode() {
            return t.hashCode();
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof DelayedItem) {
                return object.hashCode() == hashCode() ? true : false;
            }
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int cacheNumber = 10;
        int liveTime;
        DelayQueueDemo1<String, Integer> cache = new DelayQueueDemo1<>();

        for (int i = 0; i < cacheNumber; i++) {
            liveTime = random.nextInt(3000);
            System.out.println(i + "  " + liveTime);
            cache.put(i + "", i, random.nextInt(liveTime));
            if (random.nextInt(cacheNumber) > 7) {
                liveTime = random.nextInt(3000);
                System.out.println(i + "  " + liveTime);
                cache.put(i + "", i, random.nextInt(liveTime));
            }
        }

        Thread.sleep(3000);
        System.out.println();
    }

}