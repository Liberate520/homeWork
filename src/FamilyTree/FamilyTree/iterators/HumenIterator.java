package FamilyTree.FamilyTree.iterators;

import FamilyTree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumenIterator implements Iterator<Human> {
    private int index;
    private List<Human> humanList;

    public HumenIterator(List<Human> humanList) {
        this.humanList = humanList;
    }


    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
