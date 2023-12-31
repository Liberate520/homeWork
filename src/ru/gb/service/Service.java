package ru.gb.service;

import ru.gb.node.FamilyTree;
import ru.gb.node.TreeItem;
import ru.gb.person.Person;
import ru.gb.writable.FileHandlerForTree;

import java.io.IOException;
import java.io.Serializable;
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

    public void addFamilyTree(FamilyTree<E> tree) {
        familyTreesList.add(tree);
        System.out.printf("Добавлено древо с индесом: %d", treeIndex);
        this.treeIndex++;
        System.out.println();
    }

    public void addItem(E treeItem, int treeIndex) {
        FamilyTree<E> needTree = familyTreesList.get(treeIndex);
        needTree.add(treeItem);
    }

    public void createEmptyFamilyTree() {
        familyTreesList.add(new FamilyTree<E>());
        System.out.printf("Создано пустое древо с индесом: %d", treeIndex);
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

    public List<FamilyTree<E>> getFamilyTreesList() {
        return familyTreesList;
    }

    public void saveTrees() throws IOException, ClassNotFoundException {
        FileHandlerForTree fhTree = new FileHandlerForTree();
        fhTree.save((Serializable) this.familyTreesList);
    }

    public List<FamilyTree<E>> loadTrees() throws IOException, ClassNotFoundException {
        FileHandlerForTree fhTree = new FileHandlerForTree();
        return (List<FamilyTree<E>>) fhTree.loadFamilyTree();
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
}