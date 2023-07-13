package FamilyTree.sort;

import FamilyTree.tree.Person;

import java.util.Comparator;

public class AgeComparator <Being extends Person> implements Comparator <Being> {
    @Override
    public int compare(Being o1, Being o2) {
        if (o1.getBirthday().isBefore(o2.getBirthday())) {
            return 1;
        }
        if (o1.getBirthday().isAfter(o2.getBirthday())) {
            return -1;
        }
        return 0;
    }
}