package com.guo.code.snippets.tools.junit;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class T {

    public int add(int x, int y) {
        return x + y;
    }

    public int divide(int x, int y) {
        return x / y;
    }

    public static void main(String[] args) {
        int z = new T().add(3, 5);
        System.out.println(z);
    }
}
