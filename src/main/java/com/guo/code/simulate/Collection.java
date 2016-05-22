package com.guo.code.simulate;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public interface Collection<E> {

    void add(E e);
    int size();
    Iterator<E> iterator();
}
