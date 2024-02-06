package ru.home.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static DataInputStream in;

    private static DataOutputStream out;

    private static String msgFromClient;

    private static String msgFromServer;

    public static void main(String... args) {

        try (Socket socket = new Socket("localhost", 8189); Scanner sc = new Scanner(System.in)) {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Client connected");

            Thread reading = new Thread(() -> {
                while (true) {
                    try {
                        msgFromServer = in.readUTF();
                        if (msgFromServer.equals("/exit")) {
                            out.writeUTF("/close");
                            System.out.println("client logged out");
                            disconnect(socket);
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Server: " + msgFromServer);
                }
            });

            Thread writing = new Thread(() -> {
                while (true) {
                    try {
                        msgFromClient = sc.nextLine();
                        out.writeUTF(msgFromClient);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Client: " + msgFromClient);
                }
            });

            writing.start();
            reading.start();

            try {
                writing.join();
                writing.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            throw new RuntimeException("Unable to connect to server [ localhost:8189 ]");
        }

    }

    private static void disconnect(Socket socket) {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
