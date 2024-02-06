package ru.home.functionInterface.comparable.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Third {
    // Установите отношение естественного порядка для класса Cat на основании длинны имени. Т.е. чем
    // длиннее имя тем больше объект. Ваша реализация Comparable<Cat> должна быть совместима с отношением
    // эквивалентности (метод equals при необходимости можете также заменить).
    public static void main(String... args) {

        List<Cat> cats = new ArrayList<>(List.of(
                new Cat("Stepan", 12),
                new Cat("Stepan", 67),
                new Cat("bob", 2),
                new Cat("Max", 5),
                new Cat("Stepan", 12)
        ));

        Function<List<Cat>, Cat> getLongestNameCat = c -> {
            Cat longestNameCat = new Cat();
            for (Cat cat : cats) {
                if (cat.compareTo(longestNameCat) > 0) {
                    longestNameCat = cat;
                }
            }
            return longestNameCat;
        };

        System.out.println(getLongestNameCat.apply(cats));

    }

    private static class Cat implements Comparable<Cat> {

        private String name = "";
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
            return String.format("Cat %s, age %d", name, age);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || !this.getClass().isInstance(o.getClass())) return false;
            Cat anotherCat = (Cat) o;
            return this.getName().equals(anotherCat.getName()) && Objects.equals(this.getAge(), anotherCat.getAge());
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public int compareTo(Cat c) {
            if (c == null) {
                throw new NullPointerException();
            }
            if (this.getName().length() > c.getName().length()) {
                return 1;
            }
            if (this.getName().length() < c.getName().length()) {
                return -1;
            }
            return this.getAge().compareTo(c.getAge());
        }
    }

}
