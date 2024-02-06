package ru.home.classes;

// primitive type args passed by value
public class Test1 {
    int a, b;

    Test1(int i, int j) {
        a = i;
        b = j;
    }

    // passed object
    void meth(Test1 o) {
        o.a *= 2;
        o.b /= 2;
    }
}

class CallByValue {
    public static void main(String[] args) {
        int a = 15, b = 20;
        final Test1 ob = new Test1(a, b);

        System.out.println("a & b before call: " + a + " " + b);

        ob.meth(ob);

        System.out.println("a & b after call: " + a + " " + b);
    }
}

class PassObjRe {
    public static void main(String[] args) {
        final Test1 ob = new Test1(15, 20);
        System.out.println("ob.a & ob.b before call: " + ob.a + " " + ob.b);

        ob.meth(ob);

        System.out.println("ob.a & ob.b after call: " + ob.a + " " + ob.b);
    }
}