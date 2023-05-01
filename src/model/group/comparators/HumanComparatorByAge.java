package model.group.comparators;

import java.util.Comparator;

import model.human.NodeTree;

public class HumanComparatorByAge<T extends NodeTree<T>> implements Comparator<T> {
    @Override
    public int compare (T p1, T p2){
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}