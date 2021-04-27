package ru.geekbrains.level3.lesson1;

public class Apple extends Fruit {


    String name = "Apple";

    @Override
    public float getWeight() {
        return 1.0f;
    }

    @Override
    public String toString() {
        return name;
    }
}