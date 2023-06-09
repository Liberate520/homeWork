package FamilyTree;

import FamilyTree.comparators.ChildComparator;
import FamilyTree.interfaces.FileHandler;
import FamilyTree.interfaces.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    FamilyTree<Human> familyTree= new FamilyTree<Human>();

        Human person0 = new Human("Николай Калугин", 78, Gender.MALE, null, null);
        Human person1 = new Human("Зинаида Калугина", 77, Gender.FEMALE, null, null);
        Human person2 = new Human("Анатолий Кондратьев", 75, Gender.MALE, null,null);
        Human person3 = new Human("Александра Кондратьева", 75, Gender.FEMALE, null,null);
        Human person4 = new Human("Олег Кондратьев", 56, Gender.MALE, person2,person3);
        Human person5 = new Human("Татьяна Кондратьева", 57, Gender.FEMALE, null,null);
        Human person6 = new Human("Таня Кондратьева", 48, Gender.FEMALE, person0,person1);
        Human person7 = new Human("Алксандр Кондратьев", 38, Gender.MALE, person4,person5);
        Human person8 = new Human("Анна Кондратьева", 36, Gender.FEMALE, person4,person5);
        Human person9 = new Human("Иван Кондратьев", 28, Gender.MALE, person4,person6);
        Human person10 = new Human("Денис Кондратьев", 19, Gender.MALE, person4,person6);
        Human person11 = new Human("Дарья Кондратьева", 30, Gender.FEMALE, null,null);
        Human person12 = new Human("Лев Кондратьев", 1, Gender.MALE, person9,person11);

    familyTree.addMember(person0);
    familyTree.addMember(person1);
    familyTree.addMember(person2);
    familyTree.addMember(person3);
    familyTree.addMember(person4);
    familyTree.addMember(person5);
    familyTree.addMember(person6);
    familyTree.addMember(person7);
    familyTree.addMember(person8);
    familyTree.addMember(person9);
    familyTree.addMember(person10);
    familyTree.addMember(person11);
    familyTree.addMember(person12);


    FileHandler fileHandler = new FileHandler();
    fileHandler.save("/Users/kondratyevivan/Desktop/homeWorkTreeKondratyev/src/savedTree.txt", familyTree);
    Serializable loadObj = fileHandler.load("/Users/kondratyevivan/Desktop/homeWorkTreeKondratyev/src/savedTree.txt", "FamilyTree");
    FamilyTree loadedFamilyTree = (FamilyTree) loadObj;

        if (loadedFamilyTree != null) {
            ArrayList<Human> loadedFamily = loadedFamilyTree.getFamily();
            for (Human hum : loadedFamily) {
                System.out.println(hum);
                System.out.println();
            }

            familyTree.sortByAge(loadedFamily);
            System.out.println();
            System.out.println();
            System.out.println();

            for (Human hum : loadedFamily) {
                System.out.println(hum);
                System.out.println();
            }

            System.out.println();
            System.out.println();
            System.out.println();

            familyTree.sortByChild(loadedFamily);
            for (Human hum : loadedFamily) {
                System.out.println(hum);
                System.out.println();
            }

    }
    }
}
