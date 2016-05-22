package com.guo.code.simulate;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        for (int i = 0; i < 10; i++) {
            cats.add(new Cat(i));
        }
        System.out.println(cats.size());
        Iterator<Cat> it = cats.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
