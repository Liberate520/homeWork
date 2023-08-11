package model.comparators;

import model.tree.TreeItem;

import java.util.Comparator;

public class PersonComparatorByAge<T extends TreeItem> implements Comparator<T> {


    @Override
    public int compare(T o1, T o2) {
        return o1.getDateOfBirth().getYear() - o2.getDateOfBirth().getYear();
    }
}
