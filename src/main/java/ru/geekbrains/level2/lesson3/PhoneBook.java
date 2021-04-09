package ru.geekbrains.level2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String, ArrayList<String>> phoneBook;

    PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public String add(String name, String phoneNumber) {
        phoneBook.compute(name, (a,b) -> phones(b, phoneNumber));
        return "Пользователь с именем " + name + " и телефоном " + phoneNumber + " добавлен";
    }

    public String get(String name) {
        if(phoneBook.get(name) != null) {
            return name + " " + phoneBook.get(name).toString();
        } else {
            return "Такой пользователь не найден";
        }
    }

    public ArrayList<String> phones(ArrayList<String> b, String phoneNumber) {
        if (b == null)  {
            b = new ArrayList<>();
        }
        b.add(phoneNumber);
        return b;
    }
}
