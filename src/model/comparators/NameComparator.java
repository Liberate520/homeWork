package model.comparators;

import model.human.TreeMember;

import java.util.Comparator;

public class NameComparator<T extends TreeMember> implements Comparator<T> {
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
