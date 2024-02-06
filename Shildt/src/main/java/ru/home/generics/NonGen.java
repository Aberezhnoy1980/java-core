package ru.home.generics;

public class NonGen {
    Object object;

    public NonGen(Object o){
        object = o;
    }

    Object getObject() {
        return object;
    }

    void showType() {
        System.out.println("Type object is " + object.getClass().getName());
    }
}
