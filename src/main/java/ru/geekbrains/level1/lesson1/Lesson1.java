package ru.geekbrains.level1.lesson1;

public class Lesson1 {
    /*
     * Yagodin Artem geekbrains Java-university student
     * github.com/YagodinArtem/java.geekbrains
     */

    public static void main(String[] args) {
        System.out.println(functionCalculator(1.1f, 2.2f, 3.3f, 4.4f));
        System.out.println(sumRangeCheck(100, 50));
        System.out.println(sumRangeCheck(10, 10));
        isNumberPositive(0);
        isNumberPositive(-1);
        System.out.println(isNumberPositiveBoolean(-1));
        System.out.println(isNumberPositiveBoolean(0));
        helloNamePrinter("Artem");
        isYearLeap(2021);
        isYearLeap(2020);
        isYearLeap(2100);
        isYearLeap(2000);
    }

    public static void variableCreating() {
        int i = 10;

        short sh = 5;

        long lo = 999999999999999999L;

        double d = 1.1;

        float f = 1.2f;

        char c = 'x';

        byte b = 65;

        boolean bool = true;

        String s = "Hello geekbrains!";
    }

    public static float functionCalculator(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean sumRangeCheck(int a, int b) {
        return (a + b >= 10) && (a + b <=20);
    }

    public static void isNumberPositive(int a) {
        if (a >= 0) System.out.println("Переданное число является положительным");
        else System.out.println("Переданное число является отрицательным");
    }

    public static boolean isNumberPositiveBoolean(int a) {
        return a < 0;
    }

    public static void helloNamePrinter(String name) {
        System.out.println("\"Hello, " + name + "!\"");
    }

    public static void isYearLeap(int year) {
        System.out.println(year % 100 != 0 && year % 4 == 0 || year % 400 == 0);
    }
}