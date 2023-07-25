package homeWork.Interfaces;

import homeWork.FamilyTree.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyIterator implements Iterator<Human> {
    private int index;
    private List<Human> familyList;

    public FamilyIterator(List<Human> familyList) {
        this.familyList = familyList;
    }

    @Override
    public boolean hasNext() {
        return familyList.size() > index;
    }

    @Override
    public Human next() {
        return familyList.get(index++);
    }
}
