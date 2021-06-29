package ru.geekbrains.algorithms.lesson2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        MyArrayList<Integer> list = new MyArrayList<>();
        char[] special = {'b', 'i', 's'};

        for (int i = 0; i < 100000; i++) {
            list.add(random.nextInt(100));
        }

        for (char c : special) {
            long start = System.currentTimeMillis();
            sortSpeedCheck(list, c);
            System.out.println("  -- Elapsed time : " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - start) + " -- ");
        }
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
