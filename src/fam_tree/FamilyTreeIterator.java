package fam_tree;

import java.util.Iterator;
import java.util.List;

import human.Human;

public class FamilyTreeIterator implements Iterator<Human> {
    private List<Human> humanList;
    private int currentIndex;

    public FamilyTreeIterator(List<Human> humanList) {
        this.humanList = humanList;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < humanList.size();
    }

    @Override
    public Human next() {
        if (hasNext()) {
            Human nextHuman = humanList.get(currentIndex);
            currentIndex++;
            return nextHuman;
        } else {
            throw new java.util.NoSuchElementException("No more humans in the list.");
        }
    }
}
