package model.familyTree;

import model.human.Human;

import java.util.Comparator;

public class FamilyComparatorByBirthDate<E extends TreeNode> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
