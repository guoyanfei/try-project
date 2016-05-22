package com.guo.code.design.webfilter;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public interface Filter {

    void doFilter(Request request, Response response, FilterChain chain);

}
