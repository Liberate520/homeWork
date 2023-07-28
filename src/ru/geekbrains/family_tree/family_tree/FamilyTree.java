package ru.geekbrains.family_tree.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import ru.geekbrains.family_tree.human.Human;
import ru.geekbrains.family_tree.comparators.HumanByBirthDateComparator;
import ru.geekbrains.family_tree.comparators.HumanByNameComparator;

/**
 * Семейное древо, отражающее отношения членов семьи.
 */
public class FamilyTree implements Iterable<Human>, Serializable {

    /*
     * Члены семьи.
     */
    private ArrayList<Human> familyMembers;

    public FamilyTree(ArrayList<Human> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void add(Human familyMember) {
        familyMembers.add(familyMember);
    }

    @Override
    public String toString() {
        return familyMembers.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(familyMembers);
    }

    public void sortByName() {
        familyMembers.sort(new HumanByNameComparator());
    }

    public void sortByBirthDate() {
        familyMembers.sort(new HumanByBirthDateComparator());
    }

}