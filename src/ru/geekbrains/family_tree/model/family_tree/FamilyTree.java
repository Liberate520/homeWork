package ru.geekbrains.family_tree.model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import ru.geekbrains.family_tree.model.comparators.FamilyMemberByBirthDateComparator;
import ru.geekbrains.family_tree.model.comparators.FamilyMemberByNameComparator;

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

    /**
     * Добавляет члена семьи в семейное древо и возвращает true или возвращает
     * false, если член семьи уже существует в семейном древе.
     */
    public boolean add(E familyMember) {
        if (familyMembers.contains(familyMember)) {
            return false;
        }
        familyMembers.add(familyMember);
        return true;
    }

    /**
     * Возвращает true, если семейное древо не содержит людей, и false, если
     * содержит.
     */
    public boolean isEmpty() {
        return familyMembers.isEmpty();
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