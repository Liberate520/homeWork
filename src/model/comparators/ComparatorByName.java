package model.comparators;

import model.family.FamilyMember;

import java.util.Comparator;

public class ComparatorByName<E extends FamilyMember<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
