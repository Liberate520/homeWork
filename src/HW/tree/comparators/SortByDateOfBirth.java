package HW.tree.comparators;


import HW.member.Member;

import java.util.Comparator;

public class SortByDateOfBirth<T extends Member> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
