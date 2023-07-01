package com.britenight;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree("TestTree");

        //region FillingData
        tree.addPerson(new Person(0, "Ivan", "Ivanov", "Ivanovich", LocalDate.parse("1980-02-24"), Gender.Male));
        tree.addPerson(new Person(1, "Elena", "Smirnova", "Dmitrievna", LocalDate.parse("1976-06-11"), Gender.Female));
        tree.getPeople().get(0).addSpouse(tree.getPeople().get(1));
        tree.getPeople().get(1).addSpouse(tree.getPeople().get(0));
        tree.addPerson(new Person(2, "Dmitriy", "Ivanov", "Ivanovich", LocalDate.parse("2001-09-29"), Gender.Male));
        tree.getPeople().get(2).addParent(tree.getPeople().get(0));
        tree.getPeople().get(2).addParent(tree.getPeople().get(1));
        tree.getPeople().get(0).addChild(tree.getPeople().get(2));
        tree.getPeople().get(1).addChild(tree.getPeople().get(2));
        tree.addPerson(new Person(3, "Ekaterina", "Guseva", "Vitalyevna", LocalDate.parse("1999-01-15"), Gender.Female));
        tree.getPeople().get(2).addSpouse(tree.getPeople().get(3));
        tree.getPeople().get(3).addSpouse(tree.getPeople().get(2));
        tree.addPerson(new Person(4, "Egor", "Ivanov", "Dmitrievich", LocalDate.parse("2023-04-14"), Gender.Male));
        tree.addPerson(new Person(5, "Anastasiya", "Ivanova", "Dmitrievna", LocalDate.parse("2021-07-11"), Gender.Female));
        tree.getPeople().get(4).addParent(tree.getPeople().get(2));
        tree.getPeople().get(4).addParent(tree.getPeople().get(3));
        tree.getPeople().get(5).addParent(tree.getPeople().get(2));
        tree.getPeople().get(5).addParent(tree.getPeople().get(3));
        tree.getPeople().get(2).addChild(tree.getPeople().get(4));
        tree.getPeople().get(2).addChild(tree.getPeople().get(5));
        tree.getPeople().get(3).addChild(tree.getPeople().get(4));
        tree.getPeople().get(3).addChild(tree.getPeople().get(5));
        //endregion

        Person p = tree.getPeople().get(tree.getPeople().size()-1).getParents().get(0);

        System.out.println(p);
        System.out.println("\nParents:");
        for (Person i : p.getParents())
            System.out.println(i);
        System.out.println("\nSpouses:");
        for (Person i : p.getSpouses())
            System.out.println(i);
        System.out.println("\nChildren:");
        for (Person i : p.getChildren())
            System.out.println(i);
    }
}
