package com.guo.code.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gyf .
 * 2018/3/29 .
 */
public class Main {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        final AtomicBoolean go = new AtomicBoolean(false);
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("我开始执行了");
                if (atomicInteger.addAndGet(1) > 4) {
                    go.getAndSet(true);
                }
            }
        }, 5, 5, TimeUnit.SECONDS);

        while(true) {
            if (go.get()) {
                executorService.shutdown();
                System.out.println("你死了");
                break;
            }
        }
    }
}
