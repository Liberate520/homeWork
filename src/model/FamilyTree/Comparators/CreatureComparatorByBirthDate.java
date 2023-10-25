package model.FamilyTree.Comparators;

import model.creature.Interface.AgeInfo;

import java.util.Comparator;

public class CreatureComparatorByBirthDate<T extends AgeInfo> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getDataBirth().compareTo(o2.getDataBirth());
    }
}
