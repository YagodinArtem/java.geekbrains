package ru.geekbrains.lesson6;

public class Animal {

    String name;
    static int animalCounter;

    public int getAnimalCounter() {
        return animalCounter;
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("Животное " + name + " создано, количество созданных животных: " + ++animalCounter);
    }

    public void swim(int length) {
        System.out.println(name + " проплыл " + length + " м");
    }

    public void run(int length) {
        System.out.println(name + " пробежал " + length + " м");
    }
}