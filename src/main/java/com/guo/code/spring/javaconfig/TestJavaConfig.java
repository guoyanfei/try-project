package com.guo.code.spring.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class TestJavaConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);

        UserClassService userClassService = applicationContext.getBean(UserClassService.class);

        userClassService.sayHello();

        applicationContext.close();
    }
}
