package ru.home.testhomework07;

import ru.home.testhomework07.mytestapi.ClassTest;
import ru.home.testhomework07.volunteers.DefaultUser;
import ru.home.testhomework07.volunteers.NonStaticUser;

import java.lang.reflect.InvocationTargetException;

public class TestApp {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
        NonStaticUser nonStaticUser = NonStaticUser
                .getNewUser()
                .setName("Alex")
                .setAge(43)
                .setCountry("Russia")
                .build();

        Class<?> cl = DefaultUser.class;
        // parameter Class with default instance (empty constructor needed)
        ClassTest.start(cl);
        System.out.println("----------------------------");
        // parameter non static instance
        ClassTest.start(nonStaticUser);
        System.out.println("----------------------------");
        // parameter className
        ClassTest.start("ru.home.testhomework07.volunteers.StaticUser");


    }
}
