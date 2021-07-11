package ru.geekbrains.algorithms.lesson6;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
          createMaps();
    }

    public static void createMaps() {
        ArrayList<MyTreeMap<Integer, Integer>> list = new ArrayList<>();
        MyTreeMap<Integer, Integer> map;
        for (int i = 0; i < 2000000; i++) {
            map = new MyTreeMap<>();
            while (map.height() < 6) {
                map.put(rnd(),rnd());
            }
            list.add(map);
        }

        long isBalanced = 0;
        long notBalanced = 0;
        for (MyTreeMap<Integer, Integer> m : list) {
            if (m.isBalanced()) isBalanced++;
            else notBalanced++;
        }

        System.out.println("Is balanced = " + isBalanced);
        System.out.println("Not balanced = " + notBalanced);
    }

    public static int rnd() {
        int min = -100;
        int max = 100;
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
