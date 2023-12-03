package Comparators;

import Family.FamilyMember;
import Human.Human;
import java.util.Comparator;

public class ComparatorByFamilyName<E extends FamilyMember> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getFamilyName().compareTo(o2.getFamilyName());
    }
}
