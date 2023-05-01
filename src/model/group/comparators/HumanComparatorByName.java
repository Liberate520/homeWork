package model.group.comparators;

import java.util.Comparator;

import model.human.NodeTree;

public class HumanComparatorByName<T extends NodeTree<T>> implements Comparator<T>{
    @Override
    public int compare(T p1, T p2) {
        return p1.getName().compareTo(p2.getName());
    }
}