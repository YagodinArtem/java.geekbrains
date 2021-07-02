package ru.geekbrains.algorithms.lesson3;

public class Main {

    /**
     * 1. Создать программу, которая переворачивает вводимые строки (читает справа налево). +
     * реализовано через класс ReverseStringReader
     * 2. Создать класс для реализации дека. +
     * MyDeque extends MyQueue, добавлены методы
     * 3. Реализовать расширение массива в стеке при заполнении стека. +
     * reCapacity();
     * 4 ***. Реализовать расширение массива в очереди при заполнении очереди. +
     * задание выполнил (дополнил метод Insert) но не уверен, что правильно.
     */
    public static void main(String[] args) {
        ReverseStringReader rsr = new ReverseStringReader();

        System.out.println(rsr.read("Hello world! Hello java! Hello javaScript!"));
        System.out.println(rsr.read("Java strong!"));

        dequeTest();
        myQueueReCapacityTest();

    }

    public static void dequeTest() {
        MyDeque<Integer> deque = new MyDeque<>();
        deque.insert(1);
        deque.insert(2);
        deque.insert(3);
        deque.insert(4);
        deque.insert(5);

        deque.insertBegin(6);
        deque.insertBegin(7);
        deque.insertBegin(8);
        System.out.println(deque.toString());
        deque.remove();
        System.out.println(deque.toString());
        deque.removeEnd();
        System.out.println(deque.toString());
        deque.insert(15);
        System.out.println(deque.toString());
        deque.remove();
        System.out.println(deque.toString());
    }

    public static void myQueueReCapacityTest() {
        MyQueue q = new MyQueue();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.insert(6);
        q.insert(7);
        q.insert(8);
        q.insert(9);
        q.insert(10);
        q.insert(11);
        System.out.println(q.toString());
        q.insert(12);
        q.insert(13);
        q.insert(14);
        q.insert(15);
        q.insert(16);
        q.insert(17);
        q.insert(18);
        q.insert(19);
        q.insert(20);
        q.insert(21);
        q.insert(22);

        System.out.println(q.toString());
    }
}
