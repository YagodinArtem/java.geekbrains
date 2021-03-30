package ru.geekbrains.level2.lesson1.core;

import ru.geekbrains.level2.lesson1.moveableobjects.Movable;
import ru.geekbrains.level2.lesson1.obstacles.Obstacleable;
import ru.geekbrains.level2.lesson1.obstacles.Wall;

public class Service {

    public void move(Movable object, Obstacleable obstacle) {
        String obs = "расстояние";
        String agility = "пробежал";
        String metric = "km";

        if (obstacle instanceof Wall) {
            obs = "стену";
            agility = "перелез";
            metric = "m";
        }
        if (object.run() > obstacle.obstacle() && object.onRun()) {
            System.out.println(object.name() + " "
                    + agility + " " + obs + " " + obstacle.obstacle() + " " + metric);
        } else {
            System.out.println(object.name() + " не смог "
                    + agility + " " + obs + " " + obstacle.obstacle() + " " + metric);
            System.out.println(object.name() + " сходит с дистанции!");
            object.setOnRun(false);
        }
    }


}
