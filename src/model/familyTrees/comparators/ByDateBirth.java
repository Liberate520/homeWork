package model.familyTrees.comparators;

import model.members.Member;

import java.util.Comparator;

public class ByDateBirth<T extends Member> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getYearOfBirth().compareTo(o2.getYearOfBirth());
    }
}
