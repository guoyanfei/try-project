package com.guo.code.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class FilterChain implements Filter {

    List<Filter> filterChain = new ArrayList<Filter>();

    public List<Filter> getFilterChain() {
        return filterChain;
    }

    public FilterChain addFilter(Filter filter) {
        filterChain.add(filter);
        return this;
    }

    @Override
    public String doFilter(String msg) {
        for (Filter it : filterChain) {
            msg = it.doFilter(msg);
        }
        return msg;
    }
}
