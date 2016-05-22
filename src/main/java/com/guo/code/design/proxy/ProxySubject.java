package com.guo.code.design.proxy;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class ProxySubject implements Subject {

    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    private void before() {
        System.out.println("之前做了一件事情");
    }

    private void after() {
        System.out.println("之后做了一件事情");
    }

    @Override
    public void request() {
        before();
        realSubject.request();
        after();
    }
}
