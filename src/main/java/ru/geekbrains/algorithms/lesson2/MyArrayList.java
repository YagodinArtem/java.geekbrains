package ru.geekbrains.algorithms.lesson2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<E extends Comparable<E>> {
    private E[] list;
    private int size;


    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (E[]) new Comparable[capacity];

    }

    public MyArrayList() {
        list = (E[]) new Comparable[DEFAULT_CAPACITY];
    }

    /**
     * ДОМАШНЕЕ ЗАДАНИЕ
     * Увеличивает емкость массива на ((size / 2) + 1)
     */
    private void checkAndEnsureCapacity() {
        if (!hasEmptyCells()) {
            int ensuredLength = size + ((size / 2) + 1);
            list = Arrays.copyOf(list, ensuredLength);
        }
    }

    /**
     * ДОМАШНЕЕ ЗАДАНИЕ
     * Проверяет есть ли свободные ячейки в массиве
     */
    private boolean hasEmptyCells() {
        return (list.length) > size;
    }

    /**
     * ДОМАШНЕЕ ЗАДАНИЕ
     * Добавлена проверка
     */
    public void add(E item) {
        checkAndEnsureCapacity();
        list[size] = item;
        size++;
    }

    /**
     * ДОМАШНЕЕ ЗАДАНИЕ
     * Добавлена проверка
     */
    public void add(int index, E item) {
        if (index >= 0 && index < size) {
            checkAndEnsureCapacity();
            if (size - index >= 0) System.arraycopy(list, index, list, index + 1, size - index);
            list[index] = item;
            size++;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * ДОМАШНЕЕ ЗАДАНИЕ
     * Добавлена проверка
     */
    public void remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (!(index >= 0 && index < size)) throw new ArrayIndexOutOfBoundsException();
        if (size + 1 - index >= 0) System.arraycopy(list, index + 1, list, index, size + 1 - index);
        size--;
        list[size] = null;
    }

    public boolean remove(E item) {
        int i = index(item);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    public E get(int index) {
        if (!(index >= 0 && index < size)) throw new ArrayIndexOutOfBoundsException();
        return list[index];
    }

    public boolean contains(E item) {
        return index(item) > -1;
    }

    public int indexOf(E item) {
        return index(item);
    }

    private int index(E item) {
        int i;
        for (i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }


    private boolean less(E item1, E item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        E temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        E key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];

            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                }
            }
        }
    }

}
