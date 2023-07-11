package ru.home.familyTree.family_Tree.comporators;

import ru.home.familyTree.human.Human;

import java.util.Comparator;

public class HumanComparatorDateOfBirth implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2){
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
