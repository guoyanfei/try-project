package com.guo.code.spring.value;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class TestValue {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ElConfig.class);

        ElConfig resource = applicationContext.getBean(ElConfig.class);

        resource.outputResource();

        DemoUrlService demoUrlService = applicationContext.getBean(DemoUrlService.class);
        demoUrlService.sayHello();

        applicationContext.close();
    }
}
