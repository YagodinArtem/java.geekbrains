package ru.geekbrains.lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void foodAdd(int amountFood) {
        this.food += amountFood;
    }

    public void decreaseFood(int n, String name, Cat cat) {
        if (n <= food) {
            food -= n;
            cat.setFull(true);
            System.out.println("Кот " + name + " насытился!");
        }
        else System.out.println("Коту " + name + " не хватает еды :( в тарелке осталось всего " + food + " коров!");
    }
    public void info() {
        System.out.println("plate: " + food);
    }
}