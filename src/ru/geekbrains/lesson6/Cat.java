package ru.geekbrains.lesson6;

public class Cat extends Animal {

    public int runBarrier = 200;
    public int swimBarrier = 0;


    public Cat(String name) {
        super(name);
    }

    @Override
    public void swim(int length) {
        if (length < swimBarrier) System.out.println(name + " проплыл " + length + " м");
        else System.out.println("Котик " + name + " не умеет плавать!");
    }

    @Override
    public void run(int length) {
        if (length < runBarrier) System.out.println(name + " пробежал " + length + " м");
        else System.out.println("Котик " + name + " не может бежать больше " + runBarrier +" м!");
    }
}
