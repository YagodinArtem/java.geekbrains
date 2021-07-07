package ru.geekbrains.algorithms.lesson4;

public class Main {

    public static void main(String[] args) {
        mllTest();

        myStackLinkedListTest();

    }

    private static void myStackLinkedListTest() {
        MyStack<Integer> ms = new MyStack<>();

        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        ms.push(5);

        System.out.println(ms);

        ms.pop();
        ms.pop();

        System.out.println(ms);
    }

    private static void mllTest() {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);


        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
