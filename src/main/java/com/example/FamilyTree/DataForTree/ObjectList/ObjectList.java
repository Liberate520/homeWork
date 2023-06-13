package com.example.FamilyTree.DataForTree.ObjectList;

import com.example.FamilyTree.DataForTree.Family;
import com.example.FamilyTree.DataForTree.FamilyTree;
import com.example.FamilyTree.DataForTree.Gender;

import java.util.ArrayList;
import java.util.List;

public class ObjectList {
    private final List<String> objectList;

    public ObjectList() {
        this.objectList = new ArrayList<>();
        objectList.add(Human.class.getSimpleName());
        objectList.add(Cat.class.getSimpleName());
    }

    public List<String> getObjectList() {
        return objectList;
    }

    public FamilyTree<Family> getFamilyTree(String object){
        switch (object){
            case "Human":
                return getHumanFamilyTree();
            case "Cat":
                return getCatFamilyTree();
        }
        return new FamilyTree<Family>();
    }

    public Family createFamily(String object, String name, String birthday, Gender gender){
        switch (object){
            case "Human":
                return getHuman(name, birthday, gender);
            case "Cat":
                return getCat(name, birthday, gender);
        }
        System.out.println("НЕТ!!!");
        return null;
    }


    private FamilyTree<Family> getHumanFamilyTree() {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human("Olga Ivanova","1980-11-20",Gender.female));
        humanList.add(new Human("Petr Ivanov","1978-03-10", Gender.male));
        humanList.add(new Human("Alisa Ivanova","2002-08-14", Gender.female));
        humanList.add(new Human("Anton Ivanov","2005-01-10", Gender.male));
        humanList.add(new Human("Mariya Petrova","1955-02-28", Gender.female));
        humanList.add(new Human("Vasiliy Petrov","1950-09-15", Gender.male));
        humanList.add(new Human("Anna Sidorova","1960-12-15", Gender.female));
        humanList.add(new Human("Ivan Sidorov","1959-11-20", Gender.male));
        humanList.add(new Human("Svetlana Petrova","1990-10-10", Gender.female));

        FamilyTree<Family> familyTree = new FamilyTree<>();
        Family<Human> element;
        element = new Family<>(humanList.get(0));
        element.addChildren(humanList.get(2));
        element.addChildren(humanList.get(3));
        familyTree.addObjectFamilyList(element);

        element = new Family<>(humanList.get(1));
        element.addChildren(humanList.get(2));
        element.addChildren(humanList.get(3));
        familyTree.addObjectFamilyList(element);

        element = new Family<>(humanList.get(2));
        element.addParents(humanList.get(0));
        element.addParents(humanList.get(1));
        familyTree.addObjectFamilyList(element);

        element = new Family<>(humanList.get(3));
        element.addParents(humanList.get(0));
        element.addParents(humanList.get(1));
        familyTree.addObjectFamilyList(element);

        element = new Family<>(humanList.get(4));
        element.addChildren(humanList.get(0));
        element.addChildren(humanList.get(8));
        familyTree.addObjectFamilyList(element);

        element = new Family<>(humanList.get(5));
        element.addChildren(humanList.get(0));
        element.addChildren(humanList.get(8));
        familyTree.addObjectFamilyList(element);

        element = new Family<>(humanList.get(6));
        element.addChildren(humanList.get(1));
        familyTree.addObjectFamilyList(element);

        element = new Family<>(humanList.get(7));
        element.addChildren(humanList.get(1));
        familyTree.addObjectFamilyList(element);

        element = new Family<>(humanList.get(8));
        element.addParents(humanList.get(4));
        element.addParents(humanList.get(5));
        familyTree.addObjectFamilyList(element);

        return familyTree;
    }

    private FamilyTree<Family> getCatFamilyTree() {
        FamilyTree<Family> familyTree = new FamilyTree<>();
        return familyTree;
    }

    private Family getHuman(String name, String birthday, Gender gender) {
        return new Family<Human>(new Human(name,birthday,gender));
    }

    private Family getCat(String name, String birthday, Gender gender) {
        return new Family<Cat>(new Cat(name,birthday,gender));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        for (String object : objectList) {
            stringBuilder.append(index++ + ": ");
            stringBuilder.append(object);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
