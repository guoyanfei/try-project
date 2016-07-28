package com.guo.code.spring.prepost;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class BeanWayService {

    public void init() {
        System.out.println("bean init");
    }

    public BeanWayService() {
        super();
        System.out.println("构造器 - BeanWayService");
    }

    public void destroy() {
        System.out.println("bean destroy");
    }
}
