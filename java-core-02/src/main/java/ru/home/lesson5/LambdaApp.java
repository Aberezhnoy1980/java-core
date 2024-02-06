package ru.home.lesson5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class LambdaApp {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() { // cut except variable declaration
            @Override // cut
            public void run() { // cut except brackets for parameters/arguments
                System.out.println(1);
            }
        });

        Thread t2 = new Thread(() -> System.out.println(1));

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });

        Thread t4 = new Thread(() -> System.out.println("Hello"));

        final JButton jButton = new JButton();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(1);
            }
        });

        jButton.addActionListener((actionEvent) -> System.out.println(1));

    }
}
