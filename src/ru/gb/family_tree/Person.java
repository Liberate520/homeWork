package ru.gb.family_tree;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int countOfNiva;
    private String fatherName;
    private Home home;

    public Person(String name, int countOfNiva, String fatherName, Home home){
        this.name = name;
        this.countOfNiva = countOfNiva;
        this.fatherName = fatherName;
        this.home = home;
    }
}
