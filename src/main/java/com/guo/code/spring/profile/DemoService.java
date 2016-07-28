package com.guo.code.spring.profile;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class DemoService {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DemoService() {
    }

    public DemoService(String content) {
        this.content = content;
    }
}
