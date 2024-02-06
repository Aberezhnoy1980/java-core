package ru.home.singleton;

import java.util.HashMap;
import java.util.Map;

public class Multiton {

    private static final Map<String, Multiton> instances = new HashMap<>();

    public static Multiton getInstance(String key) {
        Multiton multitonInstance = instances.get(key);
        if (multitonInstance == null) {
            multitonInstance = new Multiton();
            instances.put(key, multitonInstance);
        }
        return multitonInstance;
    }
}
