package com.guo.code.spring.prepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class TestPrePost {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PrePostConfig.class);

        BeanWayService beanWayService = applicationContext.getBean(BeanWayService.class);

        JSR250WayService jsr250WayService = applicationContext.getBean(JSR250WayService.class);

        applicationContext.close();
    }
}
