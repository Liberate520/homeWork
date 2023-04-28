package service;

import essence.Essence;

import java.util.Comparator;

public class HumanComparatorByName<T> implements Comparator<Essence<T>> {

    @Override
    public int compare(Essence<T> o1, Essence<T> o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
