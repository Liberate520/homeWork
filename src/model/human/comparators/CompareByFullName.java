package model.human.comparators;

import model.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class CompareByFullName<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        String fullName1 = o1.getFirstName() + o1.getLastName();
        String fullName2 = o2.getFirstName() + o2.getLastName();
        return fullName1.compareTo(fullName2);
    }
}
