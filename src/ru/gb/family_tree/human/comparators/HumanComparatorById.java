package ru.gb.family_tree.human.comparators;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.TreeItem;

import java.util.Comparator;

public class HumanComparatorById <E extends TreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
