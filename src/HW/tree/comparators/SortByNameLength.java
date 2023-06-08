package HW.tree.comparators;


import HW.member.Member;

import java.util.Comparator;

public class SortByNameLength<T extends Member> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o2.getName().length() - o1.getName().length();
    }
}
