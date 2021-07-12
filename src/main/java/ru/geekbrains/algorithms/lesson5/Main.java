package ru.geekbrains.algorithms.lesson5;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        //1 task
        System.out.println(Mth.power(2, 3));

        //2 task
        Bag bag = new Bag(20);

        List<Item> items = new ArrayList<>();
        items.add(new Item(2, 2, "Книга"));
        items.add(new Item(5, 10, "Ковер"));
        items.add(new Item(15, 4, "Чайник"));
        items.add(new Item(4, 5, "Кофе"));
        items.add(new Item(6, 8, "Обувь"));
        items.add(new Item(1, 25, "Золото"));
        items.add(new Item(15, 100, "Рубин"));

        bag.fill(items);

        System.out.println(bag);
        System.out.println(bag.currentBagWeight());

    }
}


