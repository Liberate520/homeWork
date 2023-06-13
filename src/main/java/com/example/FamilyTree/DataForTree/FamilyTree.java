package com.example.FamilyTree.DataForTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyInterface> implements Serializable, Iterable<T> {
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
        familyList.sort(new ComparatorByBirthday<>());
    }

    public void sortByName() {
        familyList.sort(new ComparatorByName<>());
    }

    public Family getObjectFamily(T object) {
        for (int i = 0; i < getObjectFamilyList().size(); i++) {
            if (getObjectFamilyList().get(i).getObject().equals(object)) {
                return (Family) getObjectFamilyList().get(i);
            }
        }
        return new Family(object);
    }

    @Override
    public Iterator<T> iterator() {
        return familyList.iterator();
    }
}
