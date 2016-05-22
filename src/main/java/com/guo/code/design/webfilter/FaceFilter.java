package com.guo.code.design.webfilter;


/**
 * Created by gyf .
 * 16/5/22 .
 */
public class FaceFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.setRequestStr(request.getRequestStr().replace("表情", "*** ^^ ***"));
        chain.doFilter(request, response, chain);
        response.setResponseStr(response.getResponseStr() + "---face---");
    }

}
