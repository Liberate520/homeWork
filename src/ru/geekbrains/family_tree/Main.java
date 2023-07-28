package ru.geekbrains.family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import ru.geekbrains.family_tree.family_tree.FamilyTree;
import ru.geekbrains.family_tree.human.Human;
import ru.geekbrains.family_tree.human.Sex;

public class Main {
    
    public static void main(String[] args) {
        
        Human familyMember1 = new Human("Иван", "Иванов", Sex.MALE,
                                        LocalDate.of(1958,6, 15));
        Human familyMember2 = new Human("Екатерина", "Иванова", Sex.FEMALE,
                                        LocalDate.of(1961, 5, 23));
        Human familyMember3 = new Human("Степан", "Иванов", Sex.MALE,
                                        LocalDate.of(2005, 8, 5));
        Human familyMember4 = new Human("Светлана", "Иванова", Sex.FEMALE,
                                        LocalDate.of(2007, 4, 11));
        Human familyMember5 = new Human("Петр", "Иванов", Sex.MALE,
                                        LocalDate.of(1981, 10, 27),
                                        familyMember1, familyMember2,
                                        new ArrayList<>(Arrays.asList(familyMember3,
                                                                      familyMember4)));
        Human familyMember6 = new Human("Евгений", "Иванов", Sex.MALE,
                                        LocalDate.of(1983, 11, 25),
                                        familyMember1, familyMember2,
                                        new ArrayList<Human>());
        Human familyMember7 = new Human("Кристина", "Иванова", Sex.FEMALE,
                                        LocalDate.of(1984, 12, 2),
                                        familyMember1, familyMember2,
                                        new ArrayList<Human>());
        familyMember1.setChildren(new ArrayList<>(Arrays.asList(familyMember5,
                                                                familyMember6,
                                                                familyMember7)));
        familyMember2.setChildren(new ArrayList<>(Arrays.asList(familyMember5,
                                                                familyMember6,
                                                                familyMember7)));
        familyMember3.setFather(familyMember5);
        familyMember4.setFather(familyMember5);

        FamilyTree familyTree = new FamilyTree(new ArrayList<>(Arrays.asList(familyMember5,
                                                                             familyMember2,
                                                                             familyMember3,
                                                                             familyMember4,
                                                                             familyMember1,
                                                                             familyMember7,
                                                                             familyMember6)));

        System.out.println("Члены семьи до сортировки\n");
        for (Human familyMember : familyTree) {
            System.out.printf("%s ", familyMember);
        }
        System.out.println("\n");

        familyTree.sortByName();

        System.out.println("Члены семьи после сортировки по имени\n");
        for (Human familyMember : familyTree) {
            System.out.printf("%s ", familyMember);
        }
        System.out.println("\n");

        familyTree.sortByBirthDate();

        System.out.println("Члены семьи после сортировки по дате рождения\n");
        for (Human familyMember : familyTree) {
            System.out.printf("%s ", familyMember);
        }
        System.out.println("\n");
    }

}
