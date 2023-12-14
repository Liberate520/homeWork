package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class FamilyTreeComparatorByBirthDate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2){
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
