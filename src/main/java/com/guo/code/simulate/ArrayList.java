package com.guo.code.simulate;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class ArrayList<E> implements Collection<E> {

    private Object[] objects = new Object[10];

    private int index;

    public ArrayList() {
        this.index = 0;
    }

    @Override
    public void add(E e) {
        if (index == objects.length) {
            Object[] newObjects = new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index++] = e;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {

        private int size = 0;

        @Override
        public boolean hasNext() {
            return size < index;
        }

        @Override
        public E next() {
            return (E) objects[size++];
        }
    }
}
