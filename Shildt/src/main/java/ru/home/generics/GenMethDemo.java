package ru.home.generics;

public class GenMethDemo {
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++) {
            if (x.equals(y[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};

        if (isIn(2, nums))
            System.out.println("number 2 is contained in nums");
        if (!isIn(7, nums))
            System.out.println("number 7 is missing from nums" + "\n");

        String[] strs = {"One", "Two", "Three", "Four", "Five"};

        if(isIn("Two", strs))
            System.out.println("Two is contained in strs");
        if(!isIn("Seven", strs))
            System.out.println("Seven is missing from strs");
    }
}
