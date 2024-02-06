package ru.home.classes;

// Objects can be passed to methods as parameters
public class Test {
    int a, b;

    Test(int i, int j) {
        a = i;
        b = j;
    }

    // return true if o parameter specified as caller object
    boolean equalTo(Test o) {
        if (o.a == a && o.b == b) return true;
        else return false;
    }
}

class PssOb {
    public static void main(String[] args) {
        final Test ob1 = new Test(100, 22);
        final Test ob2 = new Test(100, 22);
        final Test ob3 = new Test(-1, -1);

        System.out.println("ob1 == ob2: " + ob1.equalTo(ob2));
        System.out.println("ob1 == ob3: " + ob1.equalTo(ob3));
    }
}
