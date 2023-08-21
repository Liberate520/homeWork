package Model.BaseCharacter.Comparators;

import Model.BaseCharacter.BaseCharacter;

import java.util.Comparator;

public class ComparatorSortByName<T extends BaseCharacter> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
