package com.test.algorithm.frequency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class M_362_HitCounter {
    private int[] hits = new int[300];
    private int[] times = new int[300];
    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Lock readLock = reentrantReadWriteLock.readLock();
    private final Lock writeLock = reentrantReadWriteLock.writeLock();
    Thread thread1 = new Thread("thread1") {
        @Override
        public void run() {
            super.run();
            reentrantLock.lock();
            try {
                if (reentrantLock.isHeldByCurrentThread()) {
                    System.out.println(Thread.currentThread().getName() + ":thread one lock obtained");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                //ignore
            } finally {
                if (reentrantLock.isHeldByCurrentThread()) {
                    reentrantLock.unlock();
                }
            }
        }
    };
    Thread thread2 = new Thread("thread2") {
        @Override
        public void run() {
            super.run();
            reentrantLock.lock();
            if (reentrantLock.isHeldByCurrentThread()) {
                System.out.println(Thread.currentThread().getName() + "thread two lock obtained");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (reentrantLock.isHeldByCurrentThread()) {
                        reentrantLock.unlock();
                    }
                }
            }
        }
    };

    public static void main(String[] args) {
        M_362_HitCounter instance = new M_362_HitCounter();
        instance.thread1.start();
        instance.thread2.start();
        System.out.println("main thread");
    }

    private void hit(int timestamp) {
        writeLock.lock();
        try {
            int index = timestamp % 300;
            if (timestamp != hits[index]) {
                hits[index] = timestamp;
                times[index] = 1;
            } else {
                times[index]++;
            }
        } finally {
            writeLock.unlock();
        }


    }

    private int getHits(int timestamp) {
        int sum = 0;
        readLock.lock();
        try {
            for (int i = 0; i < hits.length; i++) {
                if (timestamp - 300 < hits[i]) {
                    sum += times[i];
                }
            }
        } finally {
            readLock.unlock();
        }
        return sum;

    }
}
