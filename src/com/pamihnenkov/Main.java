package com.pamihnenkov;

import com.pamihnenkov.helpers.serialization.FileHandler;
import com.pamihnenkov.model.FamilyTree;
import com.pamihnenkov.model.Human;
import com.pamihnenkov.model.enums.Gender;
import com.pamihnenkov.model.enums.Relation;

import java.time.LocalDate;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Human parent1 = new Human("Иван","Иванов","Иванович", LocalDate.of(1970,11,11),null,Gender.MALE);
        Human parent2 = new Human("Петрова","Светлана","Игоревна", LocalDate.of(1980,11,11),null,Gender.FEMALE);
        Human child1 = new Human("Александр","Иванов","Иванович", LocalDate.of(2000,11,11),null,Gender.MALE);
        child1.addParent(parent1);
        child1.addParent(parent2);

        FamilyTree<Human> familyTree = new FamilyTree<>(child1);
        Human child2 = new Human("Анастасия","Иванова", "Ивановна", LocalDate.of(2010,12,8),null, Gender.FEMALE);
        familyTree.addRelativeForPerson(parent1,child2, Relation.CHILD);


   //     System.out.println(child2 + ", возарст - " + child2.getAge());
   //     familyTree.getBrothersAndSister(child1).forEach(System.out::println);
   //     System.out.println(familyTree.findOldestMember());

    //    FileHandler fileHandler = new FileHandler();
    //    fileHandler.save(familyTree);

    //    Object input = fileHandler.load();
    //    FamilyTree familyTree = (FamilyTree) input;
        System.out.println();
        System.out.println(familyTree);
        System.out.println();
        System.out.println("Отсортировано по возрасту");
        familyTree.print(familyTree.getSortedByAge());
        System.out.println();
        System.out.println("Отсортировано по дате рождения");
        familyTree.print(familyTree.getSortedByBirthdate());
   //    System.out.println(familyTree.findOldestMember());
   //    System.out.println(familyTree.findOldestMember().getChilds().size());






    }
}
