package model.comparators;

import model.human.TreeMember;

import java.util.Comparator;

public class ChildComparator<T extends TreeMember> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getChildrenAmount(), o2.getChildrenAmount());
    }
}
