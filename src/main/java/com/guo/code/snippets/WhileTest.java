package com.guo.code.snippets;

public class WhileTest {
    public static final int END = Integer.MAX_VALUE;
    public static final int START = END - 100;

    // END = Integer.MAX_VALUE 程序会一直卡死
    // END = Integer.MAX_VALUE - 1 那么会瞬间出答案
    public static void main(String[] args) {
        int count = 0;
        for (int i = START; i <= END; i++)
            count++;
        System.out.println(count);
    }
}