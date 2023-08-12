package com.pamihnenkov.helpers.serialization;

import com.pamihnenkov.model.FamilyTreeMember;

import java.util.Comparator;

public class ComparatorByBirthday<T extends FamilyTreeMember<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
