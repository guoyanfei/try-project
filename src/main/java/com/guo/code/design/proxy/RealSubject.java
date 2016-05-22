package com.guo.code.design.proxy;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("真实做的一件事情");
    }
}
