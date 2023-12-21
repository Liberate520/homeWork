package model.familyTree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends TreeNode> implements Iterator<T> {

    private int index;
    private List<T> humanList;

    public FamilyTreeIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }
}
