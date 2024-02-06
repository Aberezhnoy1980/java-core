package ru.home.io.transientandvolotile;

public class Note {
    transient int a; // не сохраняется при сохранении объекта
    int b; // сохраняется
}
