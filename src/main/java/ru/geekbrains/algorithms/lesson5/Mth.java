package ru.geekbrains.algorithms.lesson5;

public class Mth {

    static long power(long number, long power) {
        long temp;
        if (power == 0) return 1;
        temp = power(number, power / 2);
        if (power % 2 == 0) return temp * temp;
        else return number * temp * temp;
    }
}
