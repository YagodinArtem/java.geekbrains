package ru.geekbrains.lesson5;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Alexander", "HR Director", "alexander@mail.ru", 200000.0, 79995673214L, 45);
        employees[1] = new Employee("Olga", "Community manager", "olga@mail.ru", 80000.0, 79995673214L, 41);
        employees[2] = new Employee("Nicolas", "Senior java developer", "nicolas@mail.ru", 260000.0, 79995673214L, 31);
        employees[3] = new Employee("Jim", "Junior java developer", "jim@mail.ru", 160000.0, 79995896333L, 32);
        employees[4] = new Employee("Jerry", "Assistant", "jerry@mail.ru", 80000.0, 79995673214L, 18);

        for (Employee emp : employees)
            if (emp.getAge() > 40) emp.print();
    }
}
