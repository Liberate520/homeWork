package familyTreeModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FamilyTree<Human> familyTree = new FamilyTree<Human>();//Создание семьи
        Human mihailHuman = new Human("Михаил", "Иванов", Sex.Male , 1613, 1645);
        familyTree.add(mihailHuman);//Создали и добавили отца
        Human katyaHuman = new Human("Екатерина", "Петрова", Sex.Female , 1650, 1680);
        familyTree.add(katyaHuman);//Мать
        Human alexHuman = new Human("Алексей", "Иванов", Sex.Male , 1645, 1676);
        familyTree.add(alexHuman, katyaHuman, mihailHuman);//Сын
        Human mashaHuman = new Human("Маша", "Иванова", Sex.Male , 1645, 1676);
        familyTree.add(mashaHuman, katyaHuman, mihailHuman);//Дочь
        Human fyodorHuman = new Human("Фёдор", "Иванов", Sex.Male , 1676, 1682);
        familyTree.add(fyodorHuman, katyaHuman, mihailHuman);//Малдшый сын
        Human ivan5Human = new Human("Иван", "Иванов", Sex.Male , 1682, 1696);
        familyTree.add(ivan5Human,mashaHuman);//Внук


        FileHandler FileHandler = new FileHandler();
        FileHandler.save(familyTree);//Сохраняем
        FamilyTree<Human> familyTreeNew = FileHandler.download();//Загружаем
        System.out.println(familyTreeNew.getFamilyTree());




        // private String name;
        // private String surname;
        // private Sex sex;
        // private int startDate;
        // private int endDate;
        // private Human father;
        // private Human mother;
        // private ArrayList<Human> children;

    }
    public void save(Serializable serializable) throws FileNotFoundException, IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("FamilyTree.out"));//OOP/Homework/homeWork/src/familyTreeModel/
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    public FamilyTree download() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("FamilyTree.out"));
        FamilyTree FamilyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return FamilyTree;
    }
}
