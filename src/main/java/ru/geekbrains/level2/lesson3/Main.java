package ru.geekbrains.level2.lesson3;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //First task *******************************

        Map<String, Integer> map = new HashMap<>();
        Stream.of("cat", "cat", "cat", "cat", "bird", "dog", "chicken", "dragon", "java", "fire")
                .forEach(e -> map.compute(e, (a, b) -> addValue(b)));
        System.out.println(map);

        //Second task *******************************

        PhoneBook book = new PhoneBook();
        book.add("Петрович", "+79998885522");
        book.add("Петрович", "+79991234567");
        book.add("Семеныч", "+7589625632");
        book.add("Семеныч", "+7789658965");
        book.add("Иваныч", "+7985632156");

        System.out.println(book.get("Петрович"));
        System.out.println(book.get("Семеныч"));
        System.out.println(book.get("Кузьмич"));
        System.out.println(book.get("Иваныч"));
    }

    public static int addValue(Integer value) {
        if (value == null ) return 1;
        else return ++value;
    }
}
