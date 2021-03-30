package ru.geekbrains.level2.lesson1.obstacles;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Wall implements Obstacleable{

    int wallHeight;

    @Override
    public int obstacle() {
        return this.wallHeight;
    }
}
