package com.guo.code.snippets;

public class UnicodeTest {
    public static void main(String[] args) {
        // \u0022 是双引号Unicode的转义字符
        System.out.println("a\u0022.length() +\u0022b".length());
        System.out.println("a".length() + "b".length());
    }
}