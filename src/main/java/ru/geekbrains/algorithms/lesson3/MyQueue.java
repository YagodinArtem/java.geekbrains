package ru.geekbrains.algorithms.lesson3;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyQueue<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    //0 1 2 3 4
    //  b
    //    e
    //  7

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * 4 ***. Реализовать расширение массива в очереди при заполнении очереди.
     * не уверен, что я правильно сделал.
     */
    public void insert(T item) {
        if (isFull()) {

            T[] tempArr = (T[]) new Object[size + ((size / 2) + 1)];
            System.arraycopy(list, 0, tempArr, 0, size);
            list = tempArr;

            end = size;
        }
        size++;
        list[end] = item;
        end = nextIndex((end));
    }

    public T remove() {
        T temp = peek();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return list[begin];
    }

    public T peekEnd() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return list[end - 1];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    /**
     * @param index возвращает предыдущий индекс массива list
     */
    public int previousIndex(int index) {
        if (index < 1) return list.length - 1;
        return (index - 1) % list.length;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(list) + " b = " + begin + " e = " + end;
    }

    public T[] getList() {
        return list;
    }

    public int getSize() {
        return size;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public void setList(T[] list) {
        this.list = list;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
