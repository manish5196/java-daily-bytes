package com.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedByObjectValue {
    private  XMutexFactory<Long> mutexFactory = new XMutexFactory<>();
    public int count = 0;
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newScheduledThreadPool(10);
        SynchronizedByObjectValue obj = new SynchronizedByObjectValue();
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> obj.increment());
        }
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println(obj.count);
    }

    public void increment() {
        XMutex<Long> mutex= mutexFactory.getMutex(1L);
        synchronized (mutex) {
            count++;
        }
    }

}
