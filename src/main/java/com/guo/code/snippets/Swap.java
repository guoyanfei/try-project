package com.guo.code.snippets;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class Swap {
    public static void main(String[] args) {
        int x = 1984;
        int y = 2001;
        y = (x ^= (y ^= x)) ^ y;
        System.out.println("x= " + x + "; y= " + y);
    }
}
