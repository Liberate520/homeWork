package tree.familyTree.iterators;

import tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int indx;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return indx < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(indx++);
    }
}
