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

public class Service<E extends TreeItem<E>> {
    private List<FamilyTree<E>> familyTreesList;
    private int treeIndex;

    public Service(List<FamilyTree<E>> familyTreesList) {
        this.familyTreesList = familyTreesList;

        if (!familyTreesList.isEmpty()) {
            System.out.printf("Добавлено древо с индесом: %d", treeIndex);
            this.treeIndex++;
            System.out.println();
        }
    }

    public Service() {
        this(new ArrayList<>());
    }

    public void addItem(E treeItem, int treeIndex) {
        FamilyTree<E> needTree = familyTreesList.get(treeIndex);
        needTree.add(treeItem);
    }

    public void createEmptyFamilyTree() {
        familyTreesList.add(new FamilyTree<E>());
        System.out.println("--------------------------------------------");
        System.out.printf("Создано пустое древо с индесом: %d\n", treeIndex);
        System.out.println("--------------------------------------------");

        this.treeIndex++;
        System.out.println();
    }

    public E getByName(String name, int treeIndex) {
        FamilyTree<E> tree = familyTreesList.get(treeIndex);
        return tree.getByName(name);
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();

        for (FamilyTree<E> tree : familyTreesList) {
            int index = getTreeIndex(tree);


            stringBuilder.append("\n");
            stringBuilder.append("-----------------------");
            stringBuilder.append("Индекс древа в списке: ");
            stringBuilder.append(index);
            stringBuilder.append("-----------------------");
            stringBuilder.append("\n");

            stringBuilder.append(tree);
        }

        return stringBuilder.toString();
    }

    public int getTreeIndex(FamilyTree<E> tree) {
        return this.familyTreesList.indexOf(tree);
    }

    public void saveTrees() throws IOException {
        FileHandlerForTree<E> fhTree = new FileHandlerForTree<>();
        fhTree.save((Serializable) this.familyTreesList);
    }

    public List<FamilyTree<E>> loadTrees() throws IOException, ClassNotFoundException {
        FileHandlerForTree<E> fhTree = new FileHandlerForTree<>();
        return fhTree.loadFamilyTree();
    }

    public void sortByName() {
        for (FamilyTree<E> tree : familyTreesList) {
            tree.sortByName();
        }
    }

    public void sortByAge() {
        for (FamilyTree<E> tree : familyTreesList) {
            tree.sortByAge();
        }
    }

    public void addMom(String momName, String childName, int treeIndex) {
        E mom = getByName(momName, treeIndex);
        E child = getByName(childName, treeIndex);
        child.addParent(mom);
        mom.addChild(child);
    }

    public void addDad(String dadName, String childName, int treeIndex) {
        E dad = getByName(dadName, treeIndex);
        E child = getByName(childName, treeIndex);
        child.addParent(dad);
        dad.addChild(child);
    }

    public void addChild(String parentName, String childName, int treeIndex) {
        E parent = getByName(parentName, treeIndex);
        E child = getByName(childName, treeIndex);
        parent.addChild(child);
        child.addParent(parent);
    }

    public TreeItem<E> createPerson(String name, Gender gender, LocalDate birthDate) {
        return (TreeItem<E>) new Person(name, gender, birthDate);
    }

    public void setGender(String name, String gender, int treeIndex) {
        getByName(name, treeIndex).setGender(gender);
    }

    public void setDeathDate(String name, int treeIndex, LocalDate deathDate) {
        E person = getByName(name, treeIndex);
        person.setDeathDate(deathDate);
    }
}