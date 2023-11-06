package ru.gb.f_tree.comparators;

import java.util.Comparator;
import ru.gb.f_tree.human.Human;
import ru.gb.f_tree.human.Idable;

import java.util.Comparator;

public class IdComparator<T extends Idable> implements Comparator<T> {
    @Override
    public int compare(T obj1, T obj2) {
        return obj1.getId().compareTo(obj2.getId());
    }
}