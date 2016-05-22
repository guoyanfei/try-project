package com.guo.code.simulate;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class Cat {
    public Cat(int id) {
        super();
        this.id = id;
    }

    private int id;

    @Override
    public String toString() {
        return "cat:" + id;
    }
}