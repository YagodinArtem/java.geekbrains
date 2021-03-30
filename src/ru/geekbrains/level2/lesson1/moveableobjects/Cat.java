package ru.geekbrains.level2.lesson1.moveableobjects;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cat implements Movable {

    int jump;
    int run;
    String name;
    boolean keepGoing;

    @Override
    public int run() {
        return run;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int jump() {
        return jump;
    }

    @Override
    public void distanceRun(int runPad) { }

    @Override
    public boolean onRun() { return keepGoing; }

    @Override
    public void setOnRun(boolean keepGoing) {
        this.keepGoing = keepGoing;
    }

    @Override
    public void jump(int wallHeight) { }
}
