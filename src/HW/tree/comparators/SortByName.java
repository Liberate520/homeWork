package HW.tree.comparators;

import HW.member.Member;

import java.util.Comparator;

public class SortByName<T extends Member> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
