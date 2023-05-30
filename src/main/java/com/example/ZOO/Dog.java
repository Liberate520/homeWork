package com.example.ZOO;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("Гав-гав");
    }
}
