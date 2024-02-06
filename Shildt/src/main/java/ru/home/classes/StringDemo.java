package ru.home.classes;

public class StringDemo {
    public static void main(String[] args) {

        String strOb1 = "First string";
        String strOb2 = "Second string";
        String strOb3 = strOb1 + " and " + strOb2;
        String strOb4 = strOb1;

        System.out.println(strOb1);
        System.out.println(strOb2);
        System.out.println(strOb3);

        System.out.printf("Length of strOb1 is %d\n", strOb1.length());
        System.out.printf("At index %d is symbol %s in strObb2\n", 3, strOb2.charAt(3));

        if (strOb1.equals(strOb2))
            System.out.println("strOb1 == strOb2");
        else
            System.out.println("strOb1 != strOb2");

        if (strOb1.equals(strOb4))
            System.out.println("strOb1 == strOb4");
        else
            System.out.println("strOb1 != strOb4");

        String[] str = {"One", "Two", "Three"};
        for (int i = 0; i < str.length; i++) {
            System.out.printf("[%d]: %s\n", i, str[i]);
        }
    }
}
