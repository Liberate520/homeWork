package model.comparators;

import model.human.TreeMember;

import java.util.Comparator;

public class AgeComparator<T extends TreeMember> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
