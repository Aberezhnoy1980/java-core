package ru.home.io.instanceOf;

public class InstanceOf {
    static class A {
        int i, j;
    }

    static class B {
        int i, j;
    }

    static class C extends A {
        int k;
    }

    static class D extends A {
        int k;
    }

    public static void main(String[] args) {
        final A a = new A();
        final B b = new B();
        final C c = new C();
        final D d = new D();

        if (a instanceof A) System.out.println("а является экземпляром А");
        if (b instanceof B) System.out.println("b является экземпляром B");
        if (c instanceof C) System.out.println("c является экземпляром C");
        if (c instanceof A) System.out.println("c можно привести к типу A");
        if (a instanceof C) System.out.println("a можно привести к типу C\n");

        // сравнить с порожденными типами
        A ob;
        ob = d; // ссылка на объект d
        System.out.println("ob теперь ссылается на d");
        if (ob instanceof D) System.out.println("ob является экземпляром D\n");

        ob = c; // ссылка на c
        System.out.println("ob теперь ссылается на c");
        if (ob instanceof D)
            System.out.println("ob можно привести к типу D");
        else
            System.out.println("ob нельзя привести к D");

        if (ob instanceof A) System.out.println("ob можно привести к типу A\n");

        // все объекты могут быть приведены к типу Object
        if (a instanceof Object) System.out.println("a можно привести к тиипу Object");
        if (b instanceof Object) System.out.println("b можно привести к тиипу Object");
        if (c instanceof Object) System.out.println("c можно привести к тиипу Object");
        if (d instanceof Object) System.out.println("d можно привести к тиипу Object");

    }
}
