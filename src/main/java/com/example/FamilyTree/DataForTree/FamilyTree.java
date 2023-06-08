package com.example.FamilyTree.DataForTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Family> {
    static final long serialVersionUID = 1L;
    private List<Family> familyList;

    public FamilyTree() {
        familyList = new ArrayList<>();
    }

    public void addHumanFamilyList(Family family) {
        familyList.add(family);
    }

    public List<Family> getHumanFamilyList() {
        return familyList;
    }

    public void sortByBirthday() {
        familyList.sort(new ComparatorByBirthday());
    }

    public void sortByName() {
        familyList.sort(new ComparatorByName());
    }

    @Override
    public Iterator<Family> iterator() {
        return familyList.iterator();
    }
}
