package ru.home;

import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) {
        System.out.println("What's your name? ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Hello " + name + "!");
    }
}
