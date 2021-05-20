package ru.geekbrains.level3.lesson7.examples;

import ru.geekbrains.level3.lesson7.annotations.AfterSuite;
import ru.geekbrains.level3.lesson7.annotations.BeforeSuite;
import ru.geekbrains.level3.lesson7.annotations.Test;

public class TestExample {

    @BeforeSuite
    public void beforeSuiteTest() {
        System.out.println("before suite is started");
    }

    @Test(priority = 1)
    public void firstTest() {
        System.out.println("firstTest is started priority = 1");
    }

    @Test(priority = 2)
    public void secondTest() {
        System.out.println("secondTest is started priority = 2");
    }

    @Test(priority = 4)
    public void fourthTest() {
        System.out.println("fourthTest is started priority = 4");
    }

    @Test(priority = 4)
    public void anotherFourthTest() {
        System.out.println("anotherFourthTest is started priority = 4");
    }

    @Test(priority = 3)
    public void thirdTest() {
        System.out.println("thirdTest is started  priority = 3");
    }

    @Test(priority = 10)
    public void tenTest() {
        System.out.println("tenTest is started  priority = 10");
    }

    @AfterSuite
    public void afterSuiteTest() {
        System.out.println("after suite is started");
    }
}
