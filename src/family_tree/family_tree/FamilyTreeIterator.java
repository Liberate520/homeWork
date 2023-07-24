package family_tree.family_tree;

import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private int index;

    private List<Human> treeList;

    public FamilyTreeIterator(List<Human> treeList) {
        this.treeList = treeList;
    }

    @Override
    public boolean hasNext() {
        return treeList.size()>index;
    }

    @Override
    public Human next() {
        return treeList.get(index++);
    }
}
