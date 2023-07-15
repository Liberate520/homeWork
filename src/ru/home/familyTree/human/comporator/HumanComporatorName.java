package ru.home.familyTree.human.comporator;

import ru.home.familyTree.family_Tree.TreeItem;

import java.util.Comparator;

public class HumanComporatorName<E extends TreeItem> implements Comparator<E> {
    @Override
    public  int compare(E o1, E o2){
        return o1.getName().compareTo(o2.getName());
    }
}
