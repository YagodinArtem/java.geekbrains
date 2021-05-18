package ru.geekbrains.level3.lesson7.examples;

import ru.geekbrains.level3.lesson7.annotations.Test;

public abstract class ExceptionTestExample2 {

    @Test(priority = 1)
    public void firstTest() {
        System.out.println("firstTest is started priority = 1");
    }
}
