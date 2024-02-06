package ru.home.testhomework07.volunteers;

import ru.home.testhomework07.mytestapi.AfterSuite;
import ru.home.testhomework07.mytestapi.BeforeSuite;
import ru.home.testhomework07.mytestapi.Test;

public class StaticUser {
    private static String name;
    private static int age;
    private static String country;

    public StaticUser() {
    }

    @BeforeSuite
    public static void intro() {
        System.out.println("Hello");
    }

//    @BeforeSuite
//    public static void beforeErr() {
//        System.out.println("Hello again");
//    }

    @Test(priority = 1)
    public static void aboutMe() {
        System.out.println("My name is " + name + ", i'm " + age + " years old and living in " + country);
    }

    @Test(priority = 5)
    public static void priorityFive() {
        System.out.println("priority 5");
    }

    @Test(priority = 3)
    public static void priorityThree() {
        System.out.println("priority 3");
    }

    @Test(priority = 2)
    public static void priorityTwo() {
        System.out.println("priority 2");
    }

    @AfterSuite
    public static void sayGoodbye() {
        System.out.println("Get lost! Back off bitch!! Puts your hands from me!!!");
    }

//    @AfterSuite
//    public static void afterErr() {
//        System.out.println("Don't du that!");
//    }

    public static UserBuilder getNewUser() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private final StaticUser StaticUser;

        public UserBuilder() {
            this.StaticUser = new StaticUser();
        }

        public UserBuilder setName(String name) {
            StaticUser.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            StaticUser.age = age;
            return this;
        }

        public UserBuilder setCountry(String country) {
            StaticUser.country = country;
            return this;
        }

        public StaticUser build() {
            return StaticUser;
        }
    }
}
