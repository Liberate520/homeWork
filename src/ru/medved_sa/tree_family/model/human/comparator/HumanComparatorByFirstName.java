package ru.medved_sa.tree_family.model.human.comparator;

import ru.medved_sa.tree_family.model.familyTree.EntityCreation;

import java.util.Comparator;

public class HumanComparatorByFirstName<T extends EntityCreation<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
