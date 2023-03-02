package model.entity.comparators;

import java.util.Comparator;

import model.entity.BasicEntity;

public class EntityComparatorByName<T extends BasicEntity> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
