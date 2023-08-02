package ru.gb.fam_tree.human.comparators;

import ru.gb.fam_tree.human.Human;

import java.util.Comparator;

public class ComparatorHumansByName implements Comparator<Human> {
    @Override
    public int compare(Human human1, Human human2){
        return human1.getName().compareTo(human2.getName());
    }
}
