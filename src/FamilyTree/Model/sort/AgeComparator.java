package FamilyTree.Model.sort;

import FamilyTree.Model.tree.Being;

import java.util.Comparator;

public class AgeComparator <E extends Being> implements Comparator <E> {
    @Override
    public int compare(E o1, E o2) {
        if (o1.getBirthday().isBefore(o2.getBirthday())) {
            return 1;
        }
        if (o1.getBirthday().isAfter(o2.getBirthday())) {
            return -1;
        }
        return 0;
    }
}