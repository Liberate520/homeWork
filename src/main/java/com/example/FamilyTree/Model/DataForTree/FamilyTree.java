package com.example.FamilyTree.Model.DataForTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree<T extends Family> implements Serializable, Iterable<T> {
    static final long serialVersionUID = 1L;
    private List<T> familyList;

    public FamilyTree() {
        familyList = new ArrayList<>();
    }

    public void addObjectFamilyList(T family) {
        familyList.add(family);
    }

    public List<T> getObjectFamilyList() {
        return familyList;
    }

    public void sortByBirthday() {
        familyList.sort(new ComparatorByBirthday<T>());
    }

    public void sortByName() {
        familyList.sort(new ComparatorByName<T>());
    }

    public T getObjectFamily(T object) {
        for (int i = 0; i < familyList.size(); i++) {
            if (familyList.get(i).getObject().equals(object)) {
                return familyList.get(i);
            }
        }
        return familyList.get(0);
    }

    public List<T> getFilterObject(Selection selection) {
        return familyList.stream().filter(selection::isEqual).collect(Collectors.toList());
    }

    @Override
    public Iterator<T> iterator() {
        return familyList.iterator();
    }
}
