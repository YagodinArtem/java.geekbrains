package ru.geekbrains.algorithms.lesson2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    static MyArrayList<Integer> list;
    static Random random;

    public static void main(String[] args) {
        list = new MyArrayList<>();
        random = new Random();
        char[] special = {'b', 'i', 's'};

        for (char c : special) {
            long start = System.currentTimeMillis();
            sortSpeedCheck(listInit(), c);
            System.out.println("  -- Elapsed time : " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - start) + " -- ");
        }
    }

    private static MyArrayList<Integer> listInit() {
        list = new MyArrayList<>();
        for (int i = 0; i < 100000; i++) list.add(random.nextInt(100));
        return list;
    }

    private static <E extends Comparable<E>> void sortSpeedCheck(MyArrayList<E> list, char sortType) {
        switch (sortType) {
            case 'b':
                System.out.println("Bubble sort");
                list.bubbleSort();
                break;
            case 'i':
                System.out.println("Insertion sort");
                list.insertionSort();
                break;
            case 's':
                System.out.println("Selection sort");
                list.selectionSort();
                break;
        }
    }
}
