package com.guo.code.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

    public static void main(String[] args) throws Exception {

        Callable<Integer> callable = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                int N = 4;
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    // Thread.sleep 方法是可以响应中断的，
                    // 如果你的代码需要“超时则线程结束”的效果，那么你的代码也应该要能够响应中断
                    Thread.sleep(100);
                    sum += i;
                }
                throw new Exception();
//                return sum;
            }
        };

        // 代码2, 代码2 运行的最长时间为 timeout
        int timeout = 1000;
        Integer timeoutValue = -1;
        TimeoutCallable<Integer> timeoutCallable = new TimeoutCallable<>(callable, timeout, timeoutValue);
        ExecutorService executor = Executors.newFixedThreadPool(20);
        Future<Integer> future = executor.submit(timeoutCallable);

        Integer result = future.get();
        // end 代码2

        // 代码3
        if (timeoutValue.equals(result)) {
            System.out.println("--任务超时--");
        } else {
            System.out.println("任务结果：" + result);
        }
        // end 代码3
    }
}
