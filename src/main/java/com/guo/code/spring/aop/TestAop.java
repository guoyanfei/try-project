package com.guo.code.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class TestAop {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);

        DemoAnnotationService demoAnnotationService = applicationContext.getBean(DemoAnnotationService.class);

        DemoMethodService demoMethodService = applicationContext.getBean(DemoMethodService.class);

        demoAnnotationService.sayHello();

        demoMethodService.sayHello();

        applicationContext.close();
    }
}
