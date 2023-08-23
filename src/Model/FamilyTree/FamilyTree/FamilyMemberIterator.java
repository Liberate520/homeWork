package Model.FamilyTree.FamilyTree;

import Model.Human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyMemberIterator<E extends EntityItem<E>> implements Iterator<E> {
    private int index;
    private List<E> familyTree;

    public FamilyMemberIterator(List<E> familyTree) {
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
