package ru.geekbrains.level2.lesson5;

import java.util.Arrays;

public class Main {

    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String[] args) {
        nonMultiThreading(arrInit());
        multiThreading(arrInit());
    }

    public static void nonMultiThreading(float[] arr) {
        long a = System.currentTimeMillis();
        arrayMath(arr);
        System.out.println("One thread method time works - " + (System.currentTimeMillis() - a));
    }

    public static void multiThreading(float[] arr) {
        long a = System.currentTimeMillis();

        Thread t = new Thread(() ->
            task(arr, Arrays.copyOfRange(arr, 0, h),0, h));
        t.start();

        Thread t1 = new Thread(() ->
            task(arr, Arrays.copyOfRange(arr, h, arr.length),h, h));
        t1.start();

        try {
            t.join();
            t1.join();
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }

        System.out.println("Two thread`s method time works - " + (System.currentTimeMillis() - a));
    }

    /**
     * Task for threads
     * @param mainArr main
     * @param subArr half of main array in case
     * @param destPos from where will new values added to mainArr (откуда начинаем записывать данные в массив-назначение)
     * @param length how many cells from subArray will be copying
     */
    private static void task(float[] mainArr, float[] subArr, int destPos, int length) {
        arrayMath(subArr);
        System.arraycopy(subArr, 0, mainArr, destPos, length);
    }

    /**
     *
     * @param arr subArray
     * @return result array with new values
     */
    public static float[] arrayMath(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    /**
     * init and
     * @return array
     */
    public static float[] arrInit() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        return arr;
    }

    /**
     * One thread method time works - 940 - example
     * Two thread`s method time works - 493 - example
     */
}
