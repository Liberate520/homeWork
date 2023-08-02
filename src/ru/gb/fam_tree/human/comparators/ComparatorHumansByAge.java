package ru.gb.fam_tree.human.comparators;

import ru.gb.fam_tree.human.Human;

import java.util.Comparator;

public class ComparatorHumansByAge implements Comparator<Human> {
    @Override
    public int compare(Human human1, Human human2) {
        return Integer.compare(human1.getDaysOfLife(), human2.getDaysOfLife());
    }
}
