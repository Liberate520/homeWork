package com.example.ZOO;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("Мяу-мяу");
    }
}
