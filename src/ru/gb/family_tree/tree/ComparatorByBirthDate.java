package ru.gb.family_tree.tree;

import java.util.Comparator;

public class ComparatorByBirthDate<T extends Memberable> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) { return o1.birthDate().compareTo(o2.birthDate()); }
}
