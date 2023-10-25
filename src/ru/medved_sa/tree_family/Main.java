package ru.medved_sa.tree_family;

import ru.medved_sa.tree_family.familyTree.FamilyTree;
import ru.medved_sa.tree_family.human.Gender;
import ru.medved_sa.tree_family.human.Human;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        getFamilyTreeTest();
        writeReadObject();
    }




    private static void getFamilyTreeTest() {

        FamilyTree familyTree = new FamilyTree("Test");

        Human oleg = new Human("Олег", Gender.Male,
                LocalDate.of(1988, 3, 5));
        Human irina = new Human("Ирина", Gender.Female,
                LocalDate.of(1993, 12, 11));

//        System.out.println(oleg.toString());

        Human varvara = new Human("Кристина", Gender.Female,
                LocalDate.of(2020, 6, 15), oleg, irina);
        Human evgeniy = new Human("Евгений", Gender.Male,
                LocalDate.of(2018, 5, 12), oleg, irina);

        familyTree.addHuman(oleg);
//        familyTree.addHuman(oleg); // Выдает сообщение о не возможности добавить человека.
        familyTree.addHuman(irina);

//        familyTree.setWedding(oleg.getId(), irina.getId());
        familyTree.setWedding(oleg, irina);


        familyTree.addHuman(varvara);
        familyTree.addHuman(evgeniy);

        Human larisa = new Human("Лариса", Gender.Female,
                LocalDate.of(1955, 9, 1));

        larisa.addChild(oleg);

//        System.out.println(larisa);
        familyTree.addHuman(larisa);

        System.out.println(familyTree);


//        System.out.println(oleg.getFindInfoAboutChildren());
//        System.out.println(oleg.getBirthDate());
//        System.out.println(evgeniy.getFindMotherName());
//        System.out.println(evgeniy.getFindFatherName());
//        System.out.println(evgeniy.getFather());
//        System.out.println(larisa.getAge());
//        System.out.println(familyTree.getById(4));
//        System.out.println(familyTree.getSiblings(3));
//        System.out.println(familyTree.getByFirstName(irina.getFirstName()));

    }


    private static void writeReadObject() throws IOException, ClassNotFoundException {

        FamilyTree familyTree = new FamilyTree("Serializable");

        Human oleg = new Human("Олег", Gender.Male,
                LocalDate.of(1988, 3, 5));
        Human irina = new Human("Ирина", Gender.Female,
                LocalDate.of(1993, 12, 11));

        familyTree.addHuman(oleg);
        familyTree.addHuman(irina);

        familyTree.setWedding(oleg, irina);




        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("src/ru/medved_sa/tree_family/familyTree.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();


        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("src/ru/medved_sa/tree_family/familyTree.out"));
        FamilyTree restoredFamilyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();


        System.out.println(restoredFamilyTree);

    }
}
