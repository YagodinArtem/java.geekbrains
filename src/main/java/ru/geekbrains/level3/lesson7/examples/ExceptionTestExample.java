package ru.geekbrains.level3.lesson7.examples;

import ru.geekbrains.level3.lesson7.annotations.AfterSuite;

public class ExceptionTestExample {

    @AfterSuite
    public void beforeSuiteTest() {
        System.out.println("before suite is started");
    }

    @AfterSuite
    public void anotherBeforeSuiteTest() {
        System.out.println("before suite is started");
    }
}
