package model;

import famalyTree.Family;
import human.Gender;
import human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Service {
    private int id;
    private Family family;
    private List<Family> families;
    private Writable writable;
    public Service(Family family){
        this.family = family;
        families = new ArrayList<>();
        families.add(family);
    }
    public Service(){
        this(new Family());
    }
    public void addTrees(Family family){
        families.add(family);
    }

    public void addHuman(String name, int yearOfBirth, Gender gender){
        family.add(new Human(id++, name, yearOfBirth, gender));
    }
    public void addChild(String name, int yearOfBirth, Gender gender, String nameOfFather, String nameOfMother){
        family.add(new Human(id++, name, yearOfBirth, gender, (Human) family.getByName(nameOfFather), (Human) family.getByName(nameOfMother)));
    }
    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Human> iterator = family.iterator();
        while (iterator.hasNext()){
            Human human = iterator.next();
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }
    public void sortByName(){
        family.sortByName();
    }
    public void sortByAge(){
        family.sortByAge();
    }
   public void saveFile(){
        Writable writable = new FileHandler();
        String filePath = "/Users/mihaillazarenko/Documents/Программа разработчик/ООП/OOP_homeWork/src/tree.txt";
        writable.save(family,filePath);

   }
   public void readFile(){
       Writable writable = new FileHandler();
       String filePath = "/Users/mihaillazarenko/Documents/Программа разработчик/ООП/OOP_homeWork/src/tree.txt";
       writable.read(filePath);
   }
}
