package ru.geekbrains.level3.lesson4;

public class Abc {

    private static String letter = "A";

    public static void main(String[] args) {
        Abc abc = new Abc();
        new Thread(abc::A).start();
        new Thread(abc::B).start();
        new Thread(abc::C).start();
    }

    private void A() {
        try {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    while (!letter.equals("A")) {
                        wait();
                    }
                    System.out.print("A");
                    letter = "B";
                    notifyAll();
                }
            }
        } catch (Exception e) {

        }
    }

    private void B() {
        try {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    while (!letter.equals("B")) {
                        wait();
                    }
                    System.out.print("B");
                    letter = "C";
                    notifyAll();
                }
            }
        } catch (Exception e) {

        }
    }

    private void C() {
        try {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    while (!letter.equals("C")) {
                        wait();
                    }
                    System.out.print("C");
                    letter = "A";
                    notifyAll();
                }
            }
        } catch (Exception e) {

        }
    }
}
