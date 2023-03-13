package model.comparator;

import java.util.Comparator;

import model.components.Human;

public class HumanComparatorByDate<T extends Human> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getYearOfBirth().compareTo(o2.getYearOfBirth()); 
    }
}
