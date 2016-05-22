package com.guo.code.snippets;

public class ForTest {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        System.out.println(j);  // 0
    }
}
