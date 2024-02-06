package ru.home.functionInterface.comparable.common;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "cat [name = " + name + ", age = " + age + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Cat otherCat = (Cat) o;
        return this.getName().equals(otherCat.getName()) && this.getAge() == otherCat.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public int compareTo(Cat o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (this.age > o.age) {
            return 1;
        }
        if (this.age < o.age) {
            return -1;
        }
        return this.name.compareTo(o.name);
    }
}

