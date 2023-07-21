package com.pamihnenkov;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Human parent1 = new Human("Иван","Иванов","Иванович", LocalDate.of(1970,11,11),Gender.MALE);
        Human parent2 = new Human("Петрова","Светлана","Игоревна", LocalDate.of(1980,11,11),Gender.FEMALE);
        Human child1 = new Human("Александр","Иванов","Иванович", LocalDate.of(2000,11,11),Gender.MALE);
        child1.addParent(parent1);
        child1.addParent(parent2);


        FamilyTree familyTree = new FamilyTree(child1);
        Human child2 = new Human("Анастасия","Иванова", "Ивановна",LocalDate.of(2010,12,8),Gender.FEMALE);
        familyTree.addRelativeForPerson(parent1,child2,Relation.CHILD);


    }
}
