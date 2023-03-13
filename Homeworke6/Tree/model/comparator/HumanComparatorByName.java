package model.comparator;

import java.util.Comparator;

import model.components.Human;

public class HumanComparatorByName<T extends Human> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
    
}
