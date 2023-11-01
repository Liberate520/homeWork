package ru.gb.f_tree.comparators;

import java.util.Comparator;
import ru.gb.f_tree.human.Human;

public class AgeComparator implements Comparator<Human> {
    @Override
    public int compare(Human human1, Human human2) {
        return Integer.compare(human1.getAge(), human2.getAge());
    }
}
