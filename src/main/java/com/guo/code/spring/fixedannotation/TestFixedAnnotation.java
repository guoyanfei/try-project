package com.guo.code.spring.fixedannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class TestFixedAnnotation {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FixedAnnotationConfig.class);

        DemoService demoService = context.getBean(DemoService.class);

        demoService.outputResult();
        context.close();
    }
}
