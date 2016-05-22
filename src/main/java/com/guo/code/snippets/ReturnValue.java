package com.guo.code.snippets;

public class ReturnValue {
    public static void main(String[] args) {
        System.out.println(decision()); // false
    }

    public static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }
}