package ru.home.functionInterface.comparator.common;

import java.util.Objects;

public class Cat implements Comparable<Cat> {

    private String name;

    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Cat name: %s, age: %d\n", getName(), getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !this.getClass().isInstance(o.getClass())) return false;
        Cat anotherCat = (Cat) o;
        return this.getName().equals(anotherCat.getName()) && this.getAge().equals(anotherCat.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Cat cat) {
        if (cat == null) {
            throw new NullPointerException();
        }
        if (this.getAge() > cat.getAge()) {
            return 1;
        }
        if (this.getAge() < cat.getAge()) {
            return -1;
        }
        return this.getName().compareTo(cat.getName());
    }
}
