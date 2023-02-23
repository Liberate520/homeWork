package HWGT.comparators;

import HWGT.model.Basic;


import java.util.Comparator;

public class PersonComparatorByBirth<T extends Basic> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) { return o1.getDateOfBirth().compareTo(o2.getDateOfBirth()); }
}