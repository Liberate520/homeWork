package com.example.ZOO;

public abstract class Animal implements Speakable {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //public abstract void speak(); - убрали, т.к. берется из Speakable
}
