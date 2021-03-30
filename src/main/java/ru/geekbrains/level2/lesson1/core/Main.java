package ru.geekbrains.level2.lesson1.core;

import ru.geekbrains.level2.lesson1.moveableobjects.Cat;
import ru.geekbrains.level2.lesson1.moveableobjects.Human;
import ru.geekbrains.level2.lesson1.moveableobjects.Movable;
import ru.geekbrains.level2.lesson1.moveableobjects.Robot;
import ru.geekbrains.level2.lesson1.obstacles.Obstacleable;
import ru.geekbrains.level2.lesson1.obstacles.RunPad;
import ru.geekbrains.level2.lesson1.obstacles.Wall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static Service service;

    public static void main(String[] args) {
        service = new Service();
        for (Movable moveableObject : getJumpable()) {
            for (Obstacleable obs : getObstacles()) {
                if (moveableObject.onRun()) service.move(moveableObject, obs);
            }
        }
    }

    public static List<Movable> getJumpable() {
        return new ArrayList<>(Arrays.asList(
                new Cat(10,10,"Black cat", true),
                new Cat(50,50, "White snow", true),
                new Robot(500,500,"Bender", true),
                new Human(1,1,"Frye", true)));
    }

    public static List<Obstacleable> getObstacles() {
        return new ArrayList<>(Arrays.asList(
                new Wall(30),
                new RunPad(5),
                new Wall(15),
                new RunPad(10)));
    }
}
