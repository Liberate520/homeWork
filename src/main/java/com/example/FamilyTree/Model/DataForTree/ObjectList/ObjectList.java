package com.example.FamilyTree.Model.DataForTree.ObjectList;

import com.example.FamilyTree.Model.DataForTree.Family;
import com.example.FamilyTree.Model.DataForTree.FamilyTree;
import com.example.FamilyTree.Model.DataForTree.Gender;

import java.util.ArrayList;
import java.util.List;

public class ObjectList implements ObjectListInterface {
    private List<ObjectInterface> objectList;

    public ObjectList() {
        objectList = new ArrayList<>();
        objectList.add(new Human());
        objectList.add(new Cat());
        objectList.add(new Dog());
    }

    @Override
    public List<String> getObjectList() {
        return objectList.stream().map(o -> o.getClass().getSimpleName()).toList();
    }

    @Override
    public Family getNewObject(int object, String name, String birthday, Gender gender){
        ObjectInterface command = objectList.get(object);
        return command.getNewObject(name, birthday, gender);
    }

    @Override
    public FamilyTree<Family> getFamilyTree(int object){
        FamilyTree<Family> familyTree = new FamilyTree<>();
        return (object==0) ? getHumanFamilyTree() : familyTree;
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

}
