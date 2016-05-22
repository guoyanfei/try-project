package com.guo.code.simulate;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class TestArrayList {

    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<Cat>();
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
