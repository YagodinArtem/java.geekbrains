package ru.geekbrains.algorithms.lesson5;

import java.util.Comparator;

public class Item {

    private int weight;
    private int price;
    private String name;
    private int index;

    public Item(int weight, int price, String name) {
        this.weight = weight;
        this.price = price;
        this.name = name;
        index = price / weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public static final Comparator<Item> ITEM_COMPARATOR = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return o2.getIndex() - o1.getIndex();
        }
    };

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
