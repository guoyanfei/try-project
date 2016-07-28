package com.guo.code.spring.aop;

import org.springframework.stereotype.Service;

/**
 * Created by gyf .
 * 16/7/28 .
 */
@Service
public class DemoAnnotationService {

    @Action(name="你好啊")
    public void sayHello() {}
}
