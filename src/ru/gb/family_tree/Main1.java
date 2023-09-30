package ru.gb.family_tree;

import ru.gb.family_tree.Family.Gender;
import ru.gb.family_tree.Family.Human;
import ru.gb.family_tree.Tree.FamilyTree;
import ru.gb.family_tree.writer.FileHandler;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main1{
    public static void main(String[] args){

        String fileName = "/Users/egor/Documents/Учеба/ООП/NewProgect/src/ru/gb/family_tree/writer/test.txt";
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree =  test();
        //FamilyTree tree = (FamilyTree) fileHandler.read(fileName);
        System.out.println(tree);
        //fileHandler.save(tree, fileName);
        //tree.sortByAge();
        //tree.sortByGender();
        //tree.sortByName();
        tree.sortByDateOfBirth();
        System.out.println(tree);



    }
    static FamilyTree test(){
        FamilyTree tree  = new FamilyTree();
        Human human1 = new Human("Петрова Наталья Ивановна", Gender.Female,
                LocalDate.of(1937, 12, 12), LocalDate.of(2010, 11, 11));
        Human human2 = new Human("Петров Михаил Сергеевич", Gender.Male,
                LocalDate.of(1933, 6, 12),LocalDate.of(2011,12,21));
        Human human3 = new Human("Петров Сергей  Михайлович", Gender.Male,
                LocalDate.of(1967, 12, 12), human1, human2);
        Human human4 = new Human("Иванова Анна Михайловна", Gender.Female,
                LocalDate.of(1967, 6, 12), human1, human2);
        Human human5 = new Human("Куликова Елена Анатольевна", Gender.Female,
                LocalDate.of(1964, 10, 12));
        Human human6 = new Human("Иванов Aндрей Юрьевич", Gender.Male,
                LocalDate.of(1964, 2, 10));
        Human human7 = new Human("Петров Сергей Сергеевич", Gender.Male,
                LocalDate.of(1989, 2, 10), human5, human3);

        tree.add(human1);
        tree.add(human2);
        tree.add(human3);
        tree.add(human4);
        tree.add(human5);
        tree.add(human6);
        tree.add(human7);

        tree.setWedding(human1, human2);
        tree.setWedding(human3, human5);
        tree.setWedding(human4, human6);


        return tree;
    }

    //public void sortByName(){}
}

/*      Human human1 = new Human("Петрова Наталья Ивановна", Gender.Female,"12.12.1945", "11.11.2010");
        Human human2 = new Human("Петров Михаил Сергеевич", Gender.Male,"12.06.1945", "21.12.2011");
        Human human3 = new Human("Петров Сергей  Михайлович", Gender.Male, "12.12.1967", "No");
        Human human4 = new Human("Иванова Анна Михайловна", Gender.Female,"12.12.1967","No");
        Human human5 = new Human("Куликова Елена Анатольевна", Gender.Female,"12.10.1964","No");
        Human human6 = new Human("Иванов Aндрей Юрьевич", Gender.Male, "12.10.1964", "No");
        Human human7 = new Human("Петров Сергей Сергеевич", Gender.Male, "11.02.1989", "No");
*/