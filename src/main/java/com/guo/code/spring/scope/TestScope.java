package com.guo.code.spring.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class TestScope {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);

        DemoPrototypeService dp1 = applicationContext.getBean(DemoPrototypeService.class);
        DemoPrototypeService dp2 = applicationContext.getBean(DemoPrototypeService.class);

        DemoSingletonService ds1 = applicationContext.getBean(DemoSingletonService.class);
        DemoSingletonService ds2 = applicationContext.getBean(DemoSingletonService.class);

        System.out.println(dp1.equals(dp2));
        System.out.println(ds1.equals(ds2));
    }
}
