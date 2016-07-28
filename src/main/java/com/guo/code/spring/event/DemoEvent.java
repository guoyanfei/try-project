package com.guo.code.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class DemoEvent extends ApplicationEvent {

    private static final long serialVersionUID = -8249075468077148202L;

    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
