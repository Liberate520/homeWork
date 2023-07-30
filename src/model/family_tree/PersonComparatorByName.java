package model.family_tree;

import model.person.Person;

import java.util.Comparator;

public class PersonComparatorByName<E extends TreeNode> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
