package com.guo.code.design.filter;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class Test {

    public static void main(String[] args) {
        String msg = "表情,你叫什么名字呀?<script>,BB";
        MsgProcessor processor = new MsgProcessor();

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());
        FilterChain filterChain2 = new FilterChain();
        filterChain2.addFilter(new FaceFilter());
        filterChain.addFilter(filterChain2);

        processor.setFilterChain(filterChain);
        processor.setMsg(msg);
        System.out.println(processor.process());
    }
}
