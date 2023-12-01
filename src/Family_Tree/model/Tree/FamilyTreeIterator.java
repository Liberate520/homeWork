package Family_Tree.model.Tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator <E> implements Iterator<E> {

    private int index;
    private List<E> humanList;

    public FamilyTreeIterator(List<E> familyTree) {
        this.humanList = familyTree;
    }

    public FamilyTreeIterator() {
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }

}
