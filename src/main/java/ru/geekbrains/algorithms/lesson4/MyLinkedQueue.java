package ru.geekbrains.algorithms.lesson4;

public class MyLinkedQueue<E> {
    private MyLinkedList<E> list = new MyLinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void add(E item) {
        list.insertLast(item);
    }

    public E remove() {
        return list.removeFirst();
    }

    public E peek() {
        return list.getFirst();
    }
}
