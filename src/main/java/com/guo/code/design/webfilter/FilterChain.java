package com.guo.code.design.webfilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class FilterChain implements Filter {

    private List<Filter> filters = new ArrayList<Filter>();

    private int index = 0;

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        if (index == filters.size()) {
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request, response, chain);
    }
}
