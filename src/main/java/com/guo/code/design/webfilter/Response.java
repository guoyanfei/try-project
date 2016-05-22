package com.guo.code.design.webfilter;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class Response {

    private String responseStr;

    public Response(String responseStr) {
        this.responseStr = responseStr;
    }

    public String getResponseStr() {
        return responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }
}
