package ru.gb.model.node;

import ru.gb.model.person.Person;
import ru.gb.model.treeItem.comparators.ItemComparatorByAge;
import ru.gb.model.treeItem.comparators.ItemComparatorByName;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> treeItemList;
    private CommandMenu commandMenu;

    public FamilyTree(List<E> treeItemList) {
        this.treeItemList = treeItemList;
    }

    public FamilyTree() { this(new ArrayList<>()); }

    public void add(E treeItem) {
        if (treeItem == null) { return; }
        if (!treeItemList.contains(treeItem)) {
            treeItemList.add(treeItem);

            addToParents(treeItem);
            addToChildren(treeItem);

        }
    }

    private void addToParents(E treeItem) {
        for (E parent : treeItem.getParents()) {
            parent.addChild(treeItem);
        }
    }

    private void addToChildren(E treeItem) {
        for (E child : treeItem.getChildren()) {
            child.addParent(treeItem);
        }
    }

    public E getByName(String name) {
            for (E treeItem : treeItemList) {
                if (treeItem.getName().equalsIgnoreCase(name)) {
                    commandMenu = new CommandMenu();
                        printMenu(treeItem);
                        if (choice()) { return treeItem;}
                }
        }
        return null;
    }

    private void printMenu(E treeItem) {
        System.out.println("Вы хотите получить этого члена семьи?");
        System.out.println(treeItem);
        System.out.println(commandMenu.menu());
    }

    private boolean choice() {
        Scanner sc = new Scanner(System.in);
        String choiceStr = sc.nextLine();
        //TODO: Метод проверки числа на валидность
        int choice = Integer.parseInt(choiceStr);
        return commandMenu.execute(choice);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(treeItemList.size());
        sb.append(" объектов: \n");
        for (E treeItem : treeItemList) {
            sb.append(treeItem);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return new ItemIterator<E>(treeItemList);
    }

    public void sortByName() {
        treeItemList.sort(new ItemComparatorByName<E>());
    }

    public void sortByAge() {
        treeItemList.sort(new ItemComparatorByAge<E>());
    }

    public String getInfo(int treeIndex) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n");
        stringBuilder.append("-----------------------");
        stringBuilder.append("Индекс древа в списке: ");
        stringBuilder.append(treeIndex++);
        stringBuilder.append("-----------------------");
        stringBuilder.append("\n");

        stringBuilder.append(this);
        return stringBuilder.toString();
    }
}