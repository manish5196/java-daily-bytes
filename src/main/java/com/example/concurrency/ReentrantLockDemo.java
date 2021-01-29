package com.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class ReentrantLockDemo {
    private volatile int counter;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo obj = new ReentrantLockDemo();
        Runnable runnable = () -> obj.increment();
        final ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            service.submit(runnable);
        }
        service.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println(obj.counter);
        service.shutdownNow();
    }

    public synchronized void increment() {
//        ReentrantLock lock  = new ReentrantLock(true);
        try {
//          lock.lock();
            this.counter++;
        } finally {
//            lock.unlock();
        }

    }
}
