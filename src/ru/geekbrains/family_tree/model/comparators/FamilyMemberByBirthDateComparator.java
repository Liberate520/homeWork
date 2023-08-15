package ru.geekbrains.family_tree.model.comparators;

import java.util.Comparator;

import ru.geekbrains.family_tree.model.family_tree.FamilyMember;

public class FamilyMemberByBirthDateComparator<E extends FamilyMember> implements Comparator<E> {
    
    @Override
    public int compare(E familyMember1, E familyMember2) {
        return familyMember1.getBirthDate().compareTo(familyMember2.getBirthDate());
    }

}
