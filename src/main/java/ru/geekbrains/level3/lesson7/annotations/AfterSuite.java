package ru.geekbrains.level3.lesson7.annotations;


import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface AfterSuite {
}
