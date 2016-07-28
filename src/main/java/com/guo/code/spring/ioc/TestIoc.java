package com.guo.code.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class TestIoc {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfig.class);

        UserClassService userClassService = applicationContext.getBean(UserClassService.class);

        userClassService.sayHello();

        applicationContext.close();
    }
}
