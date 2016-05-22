package com.guo.code.design.webfilter;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class Request {

    private String requestStr;

    public Request(String requestStr) {
        this.requestStr = requestStr;
    }

    public String getRequestStr() {
        return requestStr;
    }

    public void setRequestStr(String requestStr) {
        this.requestStr = requestStr;
    }
}
