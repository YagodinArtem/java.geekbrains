package ru.geekbrains.lesson6;

public class Dog extends Animal {

    public int runBarrier = 500;
    public int swimBarrier = 10;


    public Dog(String name) {
        super(name);
    }

    @Override
    public void swim(int length) {
        if (length < swimBarrier) System.out.println(name + " проплыл " + length + " м");
        else System.out.println("Собачка " + name + " не может проплыть больше " + swimBarrier +" м!");
    }

    @Override
    public void run(int length) {
        if (length < runBarrier) System.out.println(name + " пробежал " + length + " м");
        else System.out.println("Собачка " + name + " не может бежать больше " + runBarrier +" м!");
    }
}
