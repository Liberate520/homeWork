package ru.gb.family_tree.family_tree.model.comparator;

import ru.gb.family_tree.family_tree.model.human.Human;

import java.util.Comparator;

public class FamilyComparatorByName <A> implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
