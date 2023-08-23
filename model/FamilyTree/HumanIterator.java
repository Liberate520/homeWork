package homeWork.model.FamilyTree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int index;
    private List<E> familyTree;

    public HumanIterator(List<E> humanList) {
        this.familyTree = humanList;
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
