package family_tree.family_tree;

import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends Human> implements Iterator<E> {
    private int index;

    private List<E> treeList;

    public FamilyTreeIterator(List<E> treeList) {
        this.treeList = treeList;
    }

    @Override
    public boolean hasNext() {
        return treeList.size()>index;
    }

    @Override
    public E next() {
        return treeList.get(index++);
    }
}
