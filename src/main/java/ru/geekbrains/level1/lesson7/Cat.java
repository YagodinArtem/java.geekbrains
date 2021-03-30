package ru.geekbrains.level1.lesson7;

public class Cat {

    private String name;
    private int appetite;
    private boolean full;

    public void setFull(boolean full) {
        this.full = full;
    }

    public Cat(String name, int appetite, boolean full) {
        this.name = name;
        this.appetite = appetite;
        this.full = full;
    }

    public void eat(Plate plate) {
        plate.info();
        if (appetite <= plate.getFood()) {
            plate.setFood(plate.getFood() - appetite);
            this.setFull(true);
        }
        System.out.println("Насыщение кота " + name + " c аппетитом " + appetite + " : " + full);
    }
}