package ru.home.generics;

public class Gen<T> {
    // Простой обощенный класс. Здесь Т обозначает параметр типа, который будет заменен реальным типом
    // при создании объекта типа Gen
    T ob;

    public Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Type T is: " + ob.getClass().getName());
    }
}
