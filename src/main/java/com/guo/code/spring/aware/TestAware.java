package com.guo.code.spring.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class TestAware {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AwareConfig.class);

        AwareService awareService = applicationContext.getBean(AwareService.class);

        awareService.outputResult();

        applicationContext.close();
    }
}
