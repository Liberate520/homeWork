package model.familyTree;

import model.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyIterator<T extends TreeNode> implements Iterator<T> {

    private int index;
    private List<T> humanList;

    public FamilyIterator(List<T> humanList) {
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
