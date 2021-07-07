package ru.geekbrains.algorithms.lesson4;

import java.util.EmptyStackException;

public class MyStack<T> {
    private MyLinkedList<T> list;
    private int size;

    public MyStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity: " + capacity);
        list = new MyLinkedList<>();
    }

    public MyStack() {
        list = new MyLinkedList<>();
    }

    public void push(T item) {
        list.insertFirst(item);
        size++;
    }

    public T pop() {
        T temp = peek();
        size--;
        list.remove(temp);
        return temp;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }

    public boolean isFull() {
        return size == list.size();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
