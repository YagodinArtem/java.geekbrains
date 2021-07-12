package ru.geekbrains.algorithms.lesson5;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private List<Item> inBag;

    private int capacity;
    long weight;

    public Bag(int capacity) {
        this.capacity = capacity;
        inBag = new ArrayList<>();
        weight = 0;
    }

    public void fill(List<Item> items) {
        items.sort(Item.ITEM_COMPARATOR);
        if (weight < capacity) {
            for (Item item : items) {
                if ((weight += item.getWeight()) < capacity) inBag.add(item);
                else weight -= item.getWeight();
            }
        }
    }

    @Override
    public String toString() {
        return inBag.toString();
    }

    public long currentBagWeight() {
        return weight;
    }

    public void emptyBag() {
        inBag = new ArrayList<>();
    }
}
