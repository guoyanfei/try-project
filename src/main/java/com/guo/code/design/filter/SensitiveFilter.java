package com.guo.code.design.filter;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class SensitiveFilter implements Filter {

    @Override
    public String doFilter(String msg) {
        return msg.replace("BB", "**");
    }
}
