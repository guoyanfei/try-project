package com.guo.code.spring.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Service
public class AsyncService {

    @Async
    public void executeAsyncTask(int i) {
        System.out.println("exec " + i);
    }

    @Async
    public void executeAsyncPlusTask(int i) {
        System.out.println("exec+1 " + i);
    }
}
