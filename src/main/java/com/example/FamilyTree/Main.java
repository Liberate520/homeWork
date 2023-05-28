package com.example.FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Olga Ivanova","1980-11-20", Gender.female);
        Human human2 = new Human("Petr Ivanov","1978-03-10", Gender.male);
        Human human3 = new Human("Alisa Ivanova","2002-08-14", Gender.female);
        Human human4 = new Human("Anton Ivanov","2005-01-10", Gender.male);

        List<FamilyTree> familyTree = new ArrayList<>();
        FamilyTree element = new FamilyTree(human1);
        element.addChildren(human3);
        element.addChildren(human4);
        familyTree.add(element);

        element = new FamilyTree(human2);
        element.addChildren(human3);
        element.addChildren(human4);
        familyTree.add(element);

        element = new FamilyTree(human3);
        element.addParents(human1);
        element.addParents(human2);
        familyTree.add(element);

        element = new FamilyTree(human4);
        element.addParents(human1);
        element.addParents(human2);
        familyTree.add(element);

        //System.out.println(familyTree.getFamilyTree());
        //Scanner scan = new Scanner(System.in);
        //System.out.println();
        System.out.println(familyTree);
    }
}

