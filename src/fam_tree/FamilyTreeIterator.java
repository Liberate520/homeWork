package fam_tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends TreeNode<E>> implements Iterator<E> {
    private List<E> humanList;
    private int currentIndex;

    public FamilyTreeIterator(List<E> humanList) {
        this.humanList = humanList;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < humanList.size();
    }

    @Override
    public E next() {
        if (hasNext()) {
            E nextHuman = humanList.get(currentIndex);
            currentIndex++;
            return nextHuman;
        } else {
            throw new java.util.NoSuchElementException("No more humans in the list.");
        }
    }
}
