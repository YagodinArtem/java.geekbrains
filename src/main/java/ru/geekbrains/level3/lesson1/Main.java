package ru.geekbrains.level3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // ------ first task ------
        arrayElementsSwap(0,4, 0, 1, 2, 3, 4, 5);
        arrayElementsSwap(0,4, "a", "b", "c", "d", "e");

        // ------ second task ------
        ArrayList<String> strings = arrayToList("a", "b", "c");
        ArrayList<Integer> ints = arrayToList(1, 2, 3);

        // ------ third task ------
        FruitBox<Orange> oranges = new FruitBox<>(new Orange(), 10);
        FruitBox<Apple> apples = new FruitBox<>(new Apple(), 15);

        System.out.println(oranges.compare(apples));

        System.out.println(apples.toString());
        FruitBox<Apple> anotherBoxOfApples = new FruitBox<>(new Apple(), 5);
        apples.transfer(anotherBoxOfApples);
        System.out.println(apples.toString());
        System.out.println(anotherBoxOfApples.toString());

    }

    private static <T> void arrayElementsSwap(int first, int second, T... elements) {
        if (elements.length > first && elements.length > second) {
            T elem = elements[first];
            elements[first] = elements[second];
            elements[second] = elem;
            System.out.println(Arrays.toString(elements));
        } else {
            System.err.println("размер массива меньше заданных значений для изменения позиций");
        }
    }

    private static <T> ArrayList<T> arrayToList(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }
}
