package com.guo.code.simulate;

/**
 * Created by gyf .
 * 16/5/22 .
 */
public class LinkedList<E> implements Collection<E> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public void add(E e) {
        Node node = new Node(e);
        if (head == null) {
            tail = node;
            head = node;
        }
        tail.setNext(node);
        tail = node;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {

        private Node point = head;

        @Override
        public boolean hasNext() {
            return point != null;
        }

        @Override
        public E next() {
            E data = point.getData();
            point = point.getNext();
            return data;
        }
    }
}
