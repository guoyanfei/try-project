package com.guo.code.spring.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Service
public class DemoUrlService {

    @Value("${test.qqq}")
    private String value;

    public void sayHello() {
        System.out.println(value);
    }
}
