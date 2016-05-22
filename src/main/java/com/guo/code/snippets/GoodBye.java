package com.guo.code.snippets;

public class GoodBye {
    public static void main(String[] args) {
        try {
            System.out.println("Hello world");
            System.exit(0);
        } finally {
            System.out.println("Goodbye world");    // 没了
        }
    }
}