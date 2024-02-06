package ru.home.io.thisconstructor;

public class MyClass {
    int a;
    int b;

    // инициализировать поля по отдельности
//    MyClass(int i, int j) {
//        a = i;
//        b = j;
//    }

    // инициализировать поля одним и тем же значением
//    MyClass(int i) {
//        a = i;
//        b = i;
//    }

    // присвоить полям нулевые значения по умолчанию
//    MyClass() {
//        a = 0;
//        b = 0;
//    }

    // инициализировать поля по отдельности
    MyClass(int i, int j) {
        a = i;
        b = j;
    }

    // инициализировать поля одним и тем же значением
    MyClass(int i) {
        this(i, i); // по этой ссылке вызывается конструктор MyClass(i, i)
    }

    MyClass() {
        this(0); // по этой ссылке вызывается конструктор MyClass(0)
    }

    @Override
    public String toString() {
        return String.format("a = %d и b = %d", a, b);
    }

    public static void main(String[] args) {
        final MyClass myClass1 = new MyClass(8);
        final MyClass myClass2 = new MyClass(2,4);
        final MyClass myClass3 = new MyClass();

        System.out.println(myClass1 + "\n" + myClass2 + "\n" + myClass3);
    }
}
