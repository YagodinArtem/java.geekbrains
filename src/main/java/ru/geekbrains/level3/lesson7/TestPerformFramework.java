package ru.geekbrains.level3.lesson7;


import ru.geekbrains.level3.lesson7.annotations.AfterSuite;
import ru.geekbrains.level3.lesson7.annotations.BeforeSuite;
import ru.geekbrains.level3.lesson7.annotations.Test;
import ru.geekbrains.level3.lesson7.examples.ExceptionTestExample;
import ru.geekbrains.level3.lesson7.examples.ExceptionTestExample2;
import ru.geekbrains.level3.lesson7.examples.ExceptionTestExample3;
import ru.geekbrains.level3.lesson7.examples.TestExample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestPerformFramework {


    public static void main(String[] args) {
        start(TestExample.class);

        /*
        ** Проверка отлова исключений **
        start(ExceptionTestExample.class);
        start(ExceptionTestExample2.class);
        start(ExceptionTestExample3.class);
        */

    }

    private static void start(Class testClass) {
        try {
            beforeSuiteRun(testClass);
            testRun(testClass);
            afterSuiteRun(testClass);
        } catch (IllegalAccessException e) {
            System.err.println("Вызванный метод имеет приватный доступ");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.err.println("При работе вызванного метода выброшено исключение");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.err.println("Метод не найден");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("Попытка создать объект абстрактного класса или интерфейса");
            e.printStackTrace();
        } catch (RuntimeException r) {
            System.err.println("В классе содержится более одного метода BeforeSuite \\ AfterSuite");
            r.printStackTrace();
        }
    }

    /**
     * Методы beforeSuiteRun и afterSuiteRun, собирают из массива методов передаваемого класса testClass, список методов содержащих
     * аннотацию BeforeSuite.class, в случае если размер списка более одного выбрасывается RunTimeException,
     * иначе исполняется метод помеченный аннотацией BeforeSuite.class
     *
     * @param testClass класс-тест
     * @throws InvocationTargetException обертывает исключение, вызванное вызываемым методом
     * @throws IllegalAccessException    выбрасывается в случае если метод имеет приватный доступ
     * @throws NoSuchMethodException     выбрасывается в случае если метод не найден
     * @throws InstantiationException    попытка создать объект абстрактного класса или интерфейса
     * @throws RuntimeException          выбрасывается в случае если размер списка методов с аннотацией BeforeSuite.class больше 1
     */
    private static void beforeSuiteRun(Class testClass) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        List<Method> beforeSuite = Arrays.stream(testClass.getMethods())
                .filter(method -> method.isAnnotationPresent(BeforeSuite.class)).collect(Collectors.toList());
        if (beforeSuite.size() == 0) return;
        if (beforeSuite.size() == 1) {
            Object o = testClass.newInstance();
            beforeSuite.get(0).invoke(o);
        } else throw new RuntimeException();
    }

    private static void afterSuiteRun(Class testClass) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        List<Method> afterSuite = Arrays.stream(testClass.getMethods())
                .filter(method -> method.isAnnotationPresent(AfterSuite.class)).collect(Collectors.toList());
        if (afterSuite.size() == 0) return;
        if (afterSuite.size() == 1) {
            Object o = testClass.newInstance();
            afterSuite.get(0).invoke(o);
        } else throw new RuntimeException();
    }

    /**
     * Проверяет список методов на наличие аннотации Test.class и собирает такие методы в массив, далее после сортировки
     * по приоритету вызывает эти методы
     * @param testClass класс-тест
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    private static void testRun(Class testClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] testMethods = Arrays.stream(testClass.getMethods())
                .filter(method -> method.isAnnotationPresent(Test.class)).toArray(Method[]::new);
        sortMethodsByPriority(testMethods);
        Object o = testClass.newInstance();
        for (Method testMethod : testMethods) {
             testMethod.invoke(o);
        }
    }

    /**
     * Сортировка методов класса по наивысшему приоритету
     * @param testMethods массив методов класса
     */
    private static void sortMethodsByPriority(Method[] testMethods) {
        for (int i = 0; i < testMethods.length; i++)
            for (int j = i + 1; j < testMethods.length; j++)
                if (testMethods[j].getAnnotation(Test.class).priority() > testMethods[i].getAnnotation(Test.class).priority()) {
                    Method temp = testMethods[i];
                    testMethods[i] = testMethods[j];
                    testMethods[j] = temp;
                }
    }

}
