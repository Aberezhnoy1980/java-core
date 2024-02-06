package ru.home.javaio;

import java.io.Serializable;

public class MyMessage implements Serializable {

    private static final long serialVersionUID = -4705736435997332976L; // make a manually UID constant to avoid different UID in different JVMs with auto-generation

    private Long id;
    private String text;
}
