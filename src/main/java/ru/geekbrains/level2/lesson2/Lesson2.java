package ru.geekbrains.level2.lesson2;

public class Lesson2 {

    public static void main(String[] args) {
        completeTask();
        System.err.println("\n-------------------------------");
        causeArrDataException();
        System.err.println("\n-------------------------------");
        causeArrSizeException();
        System.err.println("\n-------------------------------");
        System.out.println("End of program");

    }

    private static void completeTask() {
        try {
            System.out.println(exceptionTraining(
                            new String[][]{{"1", "2", "3", "4"},
                                    {"1", "2", "3", "4"},
                                    {"1", "2", "3", "4"},
                                    {"1", "2", "3", "4"}}));
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    private static void causeArrSizeException() {
        try {
            System.out.println(exceptionTraining(
                            new String[][]{{"1", "2", "3"},
                                    {"1", "2", "3", "4"},
                                    {"1", "2", "3", "4"},
                                    {"1", "2", "3", "4"}}));
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    private static void causeArrDataException() {
        try {
            System.out.println(exceptionTraining(
                    new String[][]{{"1", "2", "3", "qwerty"},
                                    {"1", "2", "3", "4"},
                                    {"1", "2", "3", "4"},
                                    {"1", "2", "3", "4"}}));
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }
    }



    private static int exceptionTraining(String[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4 || array.length != 4) throw new MyArraySizeException();
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(array[i][j],i,j);
                }
            }
        }
        return sum;
    }



    public static class MyArraySizeException extends ArrayIndexOutOfBoundsException {
        public MyArraySizeException() {
            super("Размер двумерного массива или его подмассивов != 4");
        }
    }

    public static class MyArrayDataException extends NumberFormatException {
        public MyArrayDataException(String s, int pos1, int pos2) {
            System.err.printf("В позиции %d %d находится %s%n", pos1, pos2, s);
        }
    }
}
