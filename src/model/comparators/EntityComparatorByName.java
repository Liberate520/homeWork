package model.comparators;

import java.util.Comparator;

import model.BasicEntity;

public class EntityComparatorByName<T extends BasicEntity> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
