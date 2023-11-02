package FamilyTree.family_tree;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import FamilyTree.human.Human;

public class FamilyTreeIterator implements Iterator<Human> {
    private int currentIndex;
    private final List<Human> humanList;

    public FamilyTreeIterator(List<Human> humanList) {
        this.humanList = humanList;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < humanList.size();
    }

    @Override
    public Human next() {
        if (hasNext()) {
            return humanList.get(currentIndex++);
        } else {
            throw new NoSuchElementException();
        }
    }
}


