package ru.gb.family_tree.Model.Family.Service;

import ru.gb.family_tree.Model.Family.ComparatotBy.HumanComparatorByAge;
import ru.gb.family_tree.Model.Family.ComparatotBy.HumanComparatorByDateOfBirth;
import ru.gb.family_tree.Model.Family.ComparatotBy.HumanComparatorByGender;
import ru.gb.family_tree.Model.Family.ComparatotBy.HumanComparatorByName;
import ru.gb.family_tree.Model.Family.Family.Gender;
import ru.gb.family_tree.Model.Family.Family.Human;
import ru.gb.family_tree.Model.Family.Family.HumanIterator;
import ru.gb.family_tree.Model.Family.Tree.FamilyTree;
import ru.gb.family_tree.Model.Family.Tree.FamilyTreeItem;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Service<E extends FamilyTreeItem<E>>  {
    private FamilyTree<E> familyTree;

    String fileName = "/Users/egor/Documents/Учеба/ООП/NewProgect/src/ru/gb/family_tree/writer/test.txt";
    FileHandler fileHandler = new FileHandler();

    public Service() {
        familyTree = new FamilyTree<>();
    }
    public void saverTree(){
        String fileName = "/Users/egor/Documents/Учеба/ООП/NewProgect/src/ru/gb/family_tree/writer/test.txt";
        FileHandler fileHandler = new FileHandler();
    }
    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FamilyInfo:\n");
        for (E human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    public FamilyTree<E> addTree(){
        FamilyTree familyTree1;
        familyTree1 = test();
        return familyTree1;
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
    public void printTree(){
        System.out.println(addTree());
    }
    public void getByAge() {
        FamilyTree ft = addTree();
        ft.sortByAge();
        System.out.println(ft);
    }
    public void getByDateOfBirth() {
        FamilyTree ft = addTree();
        ft.sortByDateOfBirth();
        System.out.println(ft);
    }
    public void getByGender() {
        FamilyTree ft = addTree();
        ft.sortByGender();
        System.out.println(ft);
    }
    public void getByName() {
        FamilyTree ft = addTree();
        ft.sortByName();
        System.out.println(ft);
    }



}
