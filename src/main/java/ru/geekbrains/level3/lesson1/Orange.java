package ru.geekbrains.level3.lesson1;

public class Orange extends Fruit {

    String name = "Orange";

    @Override
    public float getWeight() {
        return 1.5f;
    }

    @Override
    public String toString() {
        return name;
    }
}
