package ru.geekbrains.family_tree.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import ru.geekbrains.family_tree.comparators.FamilyMemberByBirthDateComparator;
import ru.geekbrains.family_tree.comparators.FamilyMemberByNameComparator;

/**
 * Семейное древо, отражающее отношения членов семьи.
 */
public class FamilyTree<E extends FamilyMember> implements Iterable<E>, Serializable {

    /**
     * Члены семьи.
     */
    private ArrayList<E> familyMembers;

    public FamilyTree(ArrayList<E> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public FamilyTree() {
        this(new ArrayList<E>());
    }

    public void add(E familyMember) {
        familyMembers.add(familyMember);
    }

    @Override
    public String toString() {
        return familyMembers.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<E>(familyMembers);
    }

    public void sortByName() {
        familyMembers.sort(new FamilyMemberByNameComparator<E>());
    }

    public void sortByBirthDate() {
        familyMembers.sort(new FamilyMemberByBirthDateComparator<E>());
    }

}