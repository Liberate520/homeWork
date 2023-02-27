package src.Comparators;

import src.FamilyTree.FTObjects;

import java.util.Comparator;

public class PersonComparatorByName<T extends FTObjects> implements Comparator<T> {

    @Override
    public int compare(T per1, T per2) {
        return per1.getName().compareTo(per2.getName());
    }
}
