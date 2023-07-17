package FamilyTree.Model.sort;

import FamilyTree.Model.tree.Being;

import java.util.Iterator;
import java.util.List;

public class PersonIterator <E extends Being> implements Iterator <E> {
    private int index;
    private List<E> treeList;

    public PersonIterator(List<E> treeList) {
        this.treeList = treeList;
    }

    @Override
    public boolean hasNext() {
        return treeList.size()> index;
    }

    @Override
    public E  next() {
        return treeList.get(index++);
    }
}
