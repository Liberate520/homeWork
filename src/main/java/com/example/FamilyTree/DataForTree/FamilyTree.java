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

    public void addHumanFamilyList(T family) {
        familyList.add(family);
    }

    public List<T> getHumanFamilyList() {
        return familyList;
    }

    public void sortByBirthday() {
        familyList.sort(new ComparatorByBirthday<>());
    }

    public void sortByName() {
        familyList.sort(new ComparatorByName<>());
    }

    public String printHumanList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T human : familyList) {
            stringBuilder.append(human.getHuman());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return familyList.iterator();
    }
}
