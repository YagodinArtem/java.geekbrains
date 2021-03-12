package ru.geekbrains.lesson5;

public class Employee {

    private String name;
    private String position;
    private String email;
    private double salary;
    private long phoneNumber;
    private int age;

    Employee(String name, String position, String email, double salary, long phoneNumber, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", phoneNumber=" + phoneNumber +
                ", age=" + age +
                '}';
    }
}
