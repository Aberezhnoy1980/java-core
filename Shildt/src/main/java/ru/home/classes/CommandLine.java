package ru.home.classes;

public class CommandLine {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.printf("args[%d]: %s\n", i, args[i]);
        }
    }
}
