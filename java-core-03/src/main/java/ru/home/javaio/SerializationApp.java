package ru.home.javaio;

import java.io.*;

public class SerializationApp {
    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("java-core-03/src/main/java/ru/home/javaio/catSer.java"))) {
            final Cat cat1 = new Cat("Barsik", 5, "White");
            final Cat cat2 = new Cat("Murzik", 3, "Black");
            final Toy toy = new Toy("Red");
            cat1.setToy(toy);
            cat2.setToy(toy);
            out.writeObject(cat1); // the Cat class must be serializable
//            out.reset(); // it is needs for set toy
            toy.setColor("Green");
            out.writeObject(cat2); // the Cat class must be serializable
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("java-core-03/src/main/java/ru/home/javaio/catSer.java"))) {
            Cat inputCat1 = (Cat) in.readObject();
            Cat inputCat2 = (Cat) in.readObject();
            System.out.println(inputCat1 +"\n" + inputCat2);
            System.out.println(inputCat1.getToy() + "\n" + inputCat2.getToy());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
