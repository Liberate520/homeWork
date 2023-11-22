package model;

import java.util.Comparator;

public class TreeComparatorByBirthDay<E extends GroupItem> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
