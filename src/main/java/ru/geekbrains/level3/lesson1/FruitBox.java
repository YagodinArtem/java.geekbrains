package ru.geekbrains.level3.lesson1;

import java.util.ArrayList;

public class FruitBox<T extends Fruit> {

    private ArrayList<T> fruits;

    public FruitBox(T e, int quantity) {
        fruits = new ArrayList<>();
        addFruit(e, quantity);
    }

    public void addFruit(T e, int quantity) {
        for (int i = 0; i < quantity; i++) fruits.add(e);
    }

    public float getWeight() {
        return fruits.size() > 0 ? fruits.get(0).getWeight() * fruits.size() : 0.0f;
    }
    
    public boolean compare(FruitBox box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.00001;
    }

    public void transfer(FruitBox<T> box) {
        box.getFruits().addAll(this.fruits);
        this.fruits = new ArrayList<>();
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    @Override
    public String toString() {
        return fruits.isEmpty() ? "FruitBox is empty" : "FruitBox{" +
                "fruits=" + fruits.get(0).toString() + "`s qnty: " + fruits.size() +
                '}';
    }
}
