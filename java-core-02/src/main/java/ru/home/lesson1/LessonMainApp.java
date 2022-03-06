package ru.home.lesson1;

public class LessonMainApp {
    public static void main(String[] args) {
        Cat cat = new Cat("White", 2);
        System.out.println(cat);
        modifyByReference(cat);
        System.out.println(cat);

        int z = 0;
        System.out.println(z);
        modifyPrimitive(z);
        System.out.println(z);
    }

    public static void modifyByReference(Cat cat) {
        cat.setColor("Purple");
    }

    public static void modifyPrimitive(int n) {
        n += 10;
    }
}
