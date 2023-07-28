package ru.geekbrains.family_tree.comparators;

import java.util.Comparator;

import ru.geekbrains.family_tree.human.Human;

public class HumanByNameComparator implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        return human1.getName().compareTo(human2.getName());
    }
    
}
