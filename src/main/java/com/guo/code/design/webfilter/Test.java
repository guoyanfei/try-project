package com.guo.code.design.webfilter;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class Test {

    public static void main(String[] args) {
        String msg = "表情,你叫什么名字呀?<script>,BB";
        Request request = new Request(msg);
        Response response = new Response("resp ");
        FilterChain chain = new FilterChain();
        chain.addFilter(new FaceFilter()).addFilter(new SensitiveFilter()).addFilter(new HtmlFilter());
        chain.doFilter(request, response, chain);
        System.out.println("request:" + request.getRequestStr());
        System.out.println("response:" + response.getResponseStr());
    }
}
