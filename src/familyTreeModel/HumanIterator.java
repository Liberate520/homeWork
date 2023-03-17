package familyTreeModel;

import java.util.ArrayList;
import java.util.Iterator;

class HumanIterator<T extends Human> implements Iterator<T> {

    private int index;
    private ArrayList<T> familyTree;

    public HumanIterator(ArrayList<T> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > index;
    }

    @Override
    public T next() {
        return familyTree.get(index++);
    }
}