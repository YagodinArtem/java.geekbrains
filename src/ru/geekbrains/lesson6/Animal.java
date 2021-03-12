package ru.geekbrains.lesson6;

public abstract class Animal {

    String name;
    static int animalCounter;

    public Animal(String name) {
        this.name = name;
        System.out.println("Животное " + name + " создано, количество созданных животных: " + ++animalCounter);
    }

    public abstract void swim(int length);

    public abstract void run(int length);
}