package ru.gb.model.service;

import ru.gb.model.node.FamilyTree;
import ru.gb.model.node.TreeItem;
import ru.gb.model.person.Person;
import ru.gb.model.treeItem.Gender;
import ru.gb.model.writable.FileHandlerForTree;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceForPeople {
    private List<FamilyTree<Person>> familyTreesList;
    private int treeIndex;

    public ServiceForPeople(List<FamilyTree<Person>> familyTreesList) {
        this.familyTreesList = familyTreesList;

        if (!familyTreesList.isEmpty()) {
            System.out.printf("Добавлено древо с индесом: %d", treeIndex);
            this.treeIndex++;
            System.out.println();
        }
    }

    public ServiceForPeople() {
        this(new ArrayList<>());
    }

    public void addItem(Person treeItem, int treeIndex) {
        FamilyTree<Person> needTree = familyTreesList.get(treeIndex);
        needTree.add(treeItem);
    }

    public void createEmptyFamilyTree() {
        familyTreesList.add(new FamilyTree<Person>());
        System.out.println("--------------------------------------------");
        System.out.printf("Создано пустое древо с индесом: %d\n", treeIndex);
        System.out.println("--------------------------------------------");

        this.treeIndex++;
        System.out.println();
    }

    public Person getByName(String name, int treeIndex) {
        FamilyTree<Person> tree = familyTreesList.get(treeIndex);
        return tree.getByName(name);
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();

        for (FamilyTree<Person> tree : familyTreesList) {
            int index = getTreeIndex(tree);
            stringBuilder.append(tree.getInfo(index));
        }

        return stringBuilder.toString();
    }

    public int getTreeIndex(FamilyTree<Person> tree) {
        return this.familyTreesList.indexOf(tree);
    }

    public void saveTrees() throws IOException {
        FileHandlerForTree<Person> fhTree = new FileHandlerForTree<>();
        fhTree.save((Serializable) this.familyTreesList);
    }

    public List<FamilyTree<Person>> loadTrees() throws IOException, ClassNotFoundException {
        FileHandlerForTree<Person> fhTree = new FileHandlerForTree<>();
        return fhTree.loadFamilyTree();
    }

    public void sortByName() {
        for (FamilyTree<Person> tree : familyTreesList) {
            tree.sortByName();
        }
    }

    public void sortByAge() {
        for (FamilyTree<Person> tree : familyTreesList) {
            tree.sortByAge();
        }
    }

    public void addMom(String momName, String childName, int treeIndex) {
        Person mom = getByName(momName, treeIndex);
        Person child = getByName(childName, treeIndex);
        if (child != null && mom != null) {
            child.addParent(mom);
            mom.addChild(child);
        } else {
            System.out.println("Этого члена семьи не найдено!");
        }
    }

    public void addDad(String dadName, String childName, int treeIndex) {
        Person dad = getByName(dadName, treeIndex);
        Person child = getByName(childName, treeIndex);
        if (child != null && dad != null) {
            child.addParent(dad);
            dad.addChild(child);
        } else {
            System.out.println("Этого члена семьи не найдено!");
        }
    }

    public void addChild(String parentName, String childName, int treeIndex) {
        Person parent = getByName(parentName, treeIndex);
        Person child = getByName(childName, treeIndex);
        if (child != null && parent != null) {
            parent.addChild(child);
            child.addParent(parent);
        } else {
            System.out.println("Этого члена семьи не найдено!");
        }
    }

    public Person createPerson(String name, Gender gender, LocalDate birthDate) {
        return new Person(name, gender, birthDate);
    }

    public void setGender(String name, String gender, int treeIndex) {
        getByName(name, treeIndex).setGender(gender);
    }

    public void setDeathDate(String name, int treeIndex, LocalDate deathDate) {
        Person person = getByName(name, treeIndex);
        person.setDeathDate(deathDate);
    }
}