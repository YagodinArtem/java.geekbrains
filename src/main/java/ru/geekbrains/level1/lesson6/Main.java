package ru.geekbrains.level1.lesson6;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Зевс"),
                new Cat("Гермес"),
                new Dog("Арес"),
                new Dog("Аид") };

        for (Animal a : animals) {
            animalMove(a, 250, 10);
            animalMove(a, 150, 9);
        }
    }

    public static void animalMove(Animal animal, int runLength, int swimLength) {
        animal.swim(swimLength);
        animal.run(runLength);
    }
}
