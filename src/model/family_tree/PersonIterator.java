package model.family_tree;

import java.util.Iterator;
import java.util.List;

public class PersonIterator<E extends TreeNode> implements Iterator<E> {
    private int index;
    private List<E> familyTree;

    public PersonIterator(List<E> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > index;
    }

    @Override
    public E next() {
        return familyTree.get(index++);
    }
}
