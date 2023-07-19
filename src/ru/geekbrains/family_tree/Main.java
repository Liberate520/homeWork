package ru.geekbrains.family_tree;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        
        Human familyMember1 = new Human("Иван", "Иванов", Sex.MALE, 1958);
        Human familyMember2 = new Human("Екатерина", "Иванова", Sex.FEMALE,
                                        1961);
        Human familyMember3 = new Human("Степан", "Иванов", Sex.MALE, 2005);
        Human familyMember4 = new Human("Светлана", "Иванова", Sex.FEMALE,
                                        2007);
        Human familyMember5 = new Human("Петр", "Иванов", Sex.MALE, 1981,
                                        familyMember1, familyMember2,
                                        new ArrayList<>(Arrays.asList(familyMember3,
                                                                      familyMember4)));
        Human familyMember6 = new Human("Евгений", "Иванов", Sex.MALE, 1983,
                                        familyMember1, familyMember2, 
                                        new ArrayList<Human>());
        Human familyMember7 = new Human("Кристина", "Иванова", Sex.FEMALE,
                                        1984, familyMember1, familyMember2,
                                        new ArrayList<Human>());
        familyMember1.setChildren(new ArrayList<>(Arrays.asList(familyMember5,
                                                                familyMember6,
                                                                familyMember7)));
        familyMember2.setChildren(new ArrayList<>(Arrays.asList(familyMember5,
                                                                familyMember6,
                                                                familyMember7)));
        familyMember3.setFather(familyMember5);
        familyMember4.setFather(familyMember5);

        FamilyTree familyTree = new FamilyTree(new ArrayList<>(Arrays.asList(familyMember1,
                                                                             familyMember2,
                                                                             familyMember5,
                                                                             familyMember6,
                                                                             familyMember7,
                                                                             familyMember3,
                                                                             familyMember4)));

        System.out.printf("Члены семьи - %s.\n", familyTree);
        System.out.printf("Родители Петра Иванова - %s, %s.\n",
                          familyMember5.getFather().getName(),
                          familyMember5.getMother().getName());
        System.out.printf("Возраст Петра Иванова - %d.\n",
                          familyMember5.getAge());
        ArrayList<Human> brotherAndSister = familyMember5.getFather().getChildren();
        brotherAndSister.remove(familyMember5);
        System.out.printf("Брат и сестра Петра Иванова - %s.\n",
                          brotherAndSister);
        System.out.printf("Дети Петра Иванова - %s.\n",
                          familyMember5.getChildren());
                        
    }

}
