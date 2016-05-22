package com.guo.code.design.filter;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class MsgProcessor {

    FilterChain filterChain;

    public void setFilterChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }

    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String process() {
        return filterChain.doFilter(msg);
    }
}
