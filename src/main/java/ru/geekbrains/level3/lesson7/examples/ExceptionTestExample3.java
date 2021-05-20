package ru.geekbrains.level3.lesson7.examples;

import ru.geekbrains.level3.lesson7.annotations.AfterSuite;
import ru.geekbrains.level3.lesson7.annotations.BeforeSuite;
import ru.geekbrains.level3.lesson7.annotations.Test;

public class ExceptionTestExample3 {


    @BeforeSuite
    public void beforeSuiteTest() {
        System.out.println("before suite is started");
    }

    @Test(priority = 1)
    public void firstTest() {
        throw new RuntimeException();
    }

    @AfterSuite
    public void afterSuiteTest() {
        System.out.println("after suite is started");
    }
}
