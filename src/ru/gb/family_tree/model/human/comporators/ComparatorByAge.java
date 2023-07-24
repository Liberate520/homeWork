package ru.gb.family_tree.model.human.comporators;

import ru.gb.family_tree.model.tree.GetByAge;

import java.util.Comparator;
public class ComparatorByAge<T extends GetByAge> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
//        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
