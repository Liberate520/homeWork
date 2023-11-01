package ru.gb.f_tree.comparators;

import java.util.Comparator;
import ru.gb.f_tree.human.Human;

public class IdComparator implements Comparator<Human> {
    @Override
    public int compare(Human human1, Human human2) {
        return human1.getId().compareTo(human2.getId());
    }
}