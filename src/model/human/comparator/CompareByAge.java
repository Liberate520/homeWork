package model.human.comparator;

import model.group.TreeItem;

import java.util.Comparator;

public class CompareByAge<E extends TreeItem> implements Comparator<E> {
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
