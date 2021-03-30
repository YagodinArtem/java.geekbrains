package ru.geekbrains.level2.lesson1.obstacles;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RunPad implements Obstacleable{

    int runPad;

    @Override
    public int obstacle() {
        return runPad;
    }
}
