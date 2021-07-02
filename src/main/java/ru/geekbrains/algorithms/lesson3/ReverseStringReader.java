package ru.geekbrains.algorithms.lesson3;

import java.util.ArrayList;

public class ReverseStringReader {

    private MyStack stack;
    private ArrayList<Character> list;
    private StringBuilder sb;

    public ReverseStringReader() {
        stack = new MyStack();
        list = new ArrayList<>();
        sb = new StringBuilder();
    }

    public String read(String input) {
        list.clear();
        for (Character c : input.toCharArray()) { stack.push(c); }
        while (!stack.isEmpty()) { list.add((Character) stack.pop()); }
        return listAsString();
    }

    public String listAsString() {
        sb.setLength(0);
        for (Character character : list) {
            sb.append(character);
        }
        return sb.toString();
    }
}
