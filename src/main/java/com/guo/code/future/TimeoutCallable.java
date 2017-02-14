package com.guo.code.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class TimeoutCallable<V> implements Callable<V> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeoutCallable.class);

    private final Callable<V> callable;
    private final long        timeout;
    private final V           timeoutV;

    /**
     * 构造一个 TimeoutCallable
     *
     * @param callable 要运行的 Callable
     * @param timeout  Callable 的最大运行时间
     * @param timeoutV Callable 超时的返回结果
     */
    public TimeoutCallable(Callable<V> callable, long timeout, V timeoutV) {
        this.callable = callable;
        this.timeout = timeout;
        this.timeoutV = timeoutV;
    }

    @Override
    public V call() throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<V> future = executor.submit(callable);
        V v = null;
        try {
            v = future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (TimeoutException ex) {
            LOGGER.warn("防作弊超时, ", ex);
        }
        return v != null ? v : timeoutV;
    }

}
