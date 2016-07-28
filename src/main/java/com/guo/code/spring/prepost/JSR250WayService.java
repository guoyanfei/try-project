package com.guo.code.spring.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class JSR250WayService {

    @PostConstruct
    public void init() {
        System.out.println("JSR250 init");
    }

    public JSR250WayService() {
        super();
        System.out.println("构造器 - JSR250WayService");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("JSR250 destroy");
    }
}
