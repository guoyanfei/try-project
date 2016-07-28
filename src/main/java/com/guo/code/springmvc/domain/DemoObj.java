package com.guo.code.springmvc.domain;

/**
 * Created by gyf .
 * 16/7/28 .
 */
public class DemoObj {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DemoObj() {
    }

    public DemoObj(Long id, String name) {

        this.id = id;
        this.name = name;
    }
}
