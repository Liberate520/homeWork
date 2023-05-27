package com.example.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> humanList = createHumanArrayList();
        System.out.println(humanList);

    }

    static List<Human> createHumanArrayList() {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human("Olga Ivanova","1980-11-20", Gender.female));
        humanList.add(new Human("Petr Ivanov","1978-03-10", Gender.male));
        humanList.add(new Human("Alisa Ivanova","2002-08-14", Gender.female));
        humanList.add(new Human("Anton Ivanov","2005-01-10", Gender.male));
        return humanList;
    }
}

