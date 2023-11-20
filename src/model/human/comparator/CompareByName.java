package model.human.comparator;

import model.group.TreeItem;

import java.util.Comparator;

public class CompareByName<E extends TreeItem> implements Comparator<E> {
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
