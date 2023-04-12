package model;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private List<Human> familyTree;
    private  int index;

    public HumanIterator(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return index < familyTree.size();
    }

    @Override
    public Human next() {
        return familyTree.get(index++);
    }
}
