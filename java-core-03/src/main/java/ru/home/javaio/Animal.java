package ru.home.javaio;

import java.io.Serializable;

public class Animal  { // can be implements Serializable and all child will be serializable too
    int legsCount;

    public Animal() { // default constructor must be defined if this superclass not serializable
    }

    public Animal(int legsCount) {
        this.legsCount = legsCount;
    }
}
