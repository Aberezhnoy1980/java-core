package ru.home.testhomework07.volunteers;

import ru.home.testhomework07.mytestapi.AfterSuite;
import ru.home.testhomework07.mytestapi.BeforeSuite;
import ru.home.testhomework07.mytestapi.Test;

public class NonStaticUser {
    private String name;
    private int age;
    private String country;

    public NonStaticUser() {
    }

    @BeforeSuite
    public void intro() {
        System.out.println("Hello");
    }

//    @BeforeSuite
//    public void beforeErr() {
//        System.out.println("Hello again");
//    }

    @Test(priority = 1)
    public void aboutMe() {
        System.out.println("My name is " + name + ", i'm " + age + " years old and living in " + country);
    }

    @Test(priority = 5)
    public void priorityFive() {
        System.out.println("priority 5");
    }

    @Test(priority = 3)
    public void priorityThree() {
        System.out.println("priority 3");
    }

    @Test(priority = 2)
    public void priorityTwo() {
        System.out.println("priority 2");
    }

    @AfterSuite
    public void sayGoodbye() {
        System.out.println("Get lost! Back off bitch!! Puts your hands from me!!!");
    }

//    @AfterSuite
//    public void afterErr() {
//        System.out.println("Don't du that!");
//    }

    public static UserBuilder getNewUser() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private final NonStaticUser nonStaticUser;

        public UserBuilder() {
            this.nonStaticUser = new NonStaticUser();
        }

        public UserBuilder setName(String name) {
            nonStaticUser.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            nonStaticUser.age = age;
            return this;
        }

        public UserBuilder setCountry(String country) {
            nonStaticUser.country = country;
            return this;
        }

        public NonStaticUser build() {
            return nonStaticUser;
        }
    }
}
