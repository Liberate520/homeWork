package ru.gb.f_tree.comparators;

import ru.gb.f_tree.human.Ageble;

import java.util.Comparator;

public class AgeComparator<T extends Ageble> implements Comparator<T> {
    @Override
    public int compare(T obj1, T obj2) {
        return Integer.valueOf(obj1.getAge()).compareTo(Integer.valueOf(obj2.getAge()));
    }
}