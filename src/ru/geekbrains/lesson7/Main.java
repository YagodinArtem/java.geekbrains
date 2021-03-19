package ru.geekbrains.lesson7;

public class Main {

    public static void main(String[] args) {
        Plate plate = new Plate(100);
        for (Cat c : catArrayInit()) {
            c.eat(plate);
        }
        plate.foodAdd(100);
    }

    public static Cat[] catArrayInit() {
        return new Cat[] {new Cat("Barsik", 20,false),
                new Cat("Black beast", 5,false),
                new Cat("White rabbit", 6,false),
                new Cat("Red dragon", 75,false),
                new Cat("Blue bird", 11,false)};
    }
}
