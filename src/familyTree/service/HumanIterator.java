package familyTree.service;

import familyTree.*;
import familyTree.familyTree.FamilyTree;
import familyTree.human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator {
    private int index;

    public List<Human> familyList;

    public HumanIterator(List<Human> familyList) {
        this.familyList = familyList;
    }

    public List<Human> getFamilyList() {
        return familyList;
    }

    @Override
    public boolean hasNext() {
        return index< familyList.size();
    }

    @Override
    public Object next() {
        return familyList.get(index++);

    }
}
