package ru.geekbrains.level1.lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void foodAdd(int amountFood) {
        this.food += amountFood;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}