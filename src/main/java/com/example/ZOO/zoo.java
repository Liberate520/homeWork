package com.example.ZOO;

import java.util.ArrayList;
import java.util.List;

public class zoo {
    public static void main(String[] args) {
        Cat cat = new Cat("Васька");
        Dog dog = new Dog("Бобик");
        Radio radio = new Radio();

        List<Speakable> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(dog);
        animals.add(radio);

        speakAll(animals);
    }

    static void speakAll(List<Speakable> speakableList){
        for (Speakable speakable:speakableList) {
            if (speakable instanceof Animal){
                System.out.print(((Animal) speakable).getName() + " говорит ");
            }
            speakable.speak();
        }
    }
}
