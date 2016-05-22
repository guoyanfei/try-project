package com.guo.code.design.proxy;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class ProxyTest {
    public static void main(String[] args) {
        ProxySubject proxySubject = new ProxySubject(new RealSubject());
        proxySubject.request();
    }
}
