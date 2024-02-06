package ru.home.lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static Socket socket;

    private static DataInputStream in;

    private static DataOutputStream out;

//    private static final Scanner sc = new Scanner(System.in);

    private static String msgFromClient;
    private static String msgFromServer;

    public static void main(String... args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Connect to server");
            socket = serverSocket.accept();
            System.out.println("Client is connected");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread reading = new Thread(() -> {
                while (true) {
                    try {
                        msgFromClient = in.readUTF();
                        if (msgFromClient.equals("/close")) {
                            out.writeUTF("/exit");
                            System.out.println("Server stopped");
                            disconnect();
                            break;
                        } else System.out.println("Client: " + msgFromClient);
                    } catch (IOException e) {
                        throw new RuntimeException("Connection with client failed");
                    }
                }
            });

            Thread writing = new Thread(() -> {
                while (true) {
                    Scanner sc = new Scanner(System.in);
                    try {
                        msgFromServer = sc.nextLine();
                        out.writeUTF(msgFromServer);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Server: " + msgFromServer);
                }
            });


            reading.start();
            writing.start();

            try {
                reading.join();
                writing.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void disconnect() {
        if (in != null && out != null && socket != null)
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
