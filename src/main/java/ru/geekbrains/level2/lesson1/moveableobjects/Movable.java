package ru.geekbrains.level2.lesson1.moveableobjects;

public interface Movable {

    void jump(int height);

    void distanceRun(int distance);

    boolean onRun();

    void setOnRun(boolean keepGoing);

    int run();

    String name();

    int jump();
}
