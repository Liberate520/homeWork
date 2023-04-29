package service;

import module.essence.Essence;

import java.util.Comparator;

public class HumanComparatorByDate<T> implements Comparator<Essence<T>> {
    @Override
    public int compare(Essence<T> o1, Essence<T> o2) {
        return o1.getDate_of_birth().compareTo(o2.getDate_of_birth());
    }
}
