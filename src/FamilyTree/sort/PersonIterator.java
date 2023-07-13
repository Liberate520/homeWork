package FamilyTree.sort;

import FamilyTree.tree.Person;

import java.util.Iterator;
import java.util.List;

public class PersonIterator <Being extends Person> implements Iterator <Being> {
    private int index;
    private List<Being> treeList;

    public PersonIterator(List<Being> treeList) {
        this.treeList = treeList;
    }

    @Override
    public boolean hasNext() {
        return treeList.size()> index;
    }

    @Override
    public Being  next() {
        return treeList.get(index++);
    }
}
