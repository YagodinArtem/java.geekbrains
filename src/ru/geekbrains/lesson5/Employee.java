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

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void print() {
        System.out.printf("\nName: %-40s\nPosition: %-15s\nEmail: %-20s\nSalary: %.2f\nPhone number: %-10d\nAge: %-3d\n",
                this.getName(), this.getPosition(), this.getEmail(), this.getSalary(), this.getPhoneNumber(), this.getAge());
    }
}
