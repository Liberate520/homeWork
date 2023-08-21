package Model.BaseCharacter.Comparators;

import Model.BaseCharacter.BaseCharacter;

import java.util.Comparator;

public class ComparatorSortByAge<T extends BaseCharacter> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
