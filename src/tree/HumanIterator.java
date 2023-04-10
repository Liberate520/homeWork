package tree;

import Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> lst;

    public HumanIterator(List<Human> humanList) {
        this.lst = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < lst.size();
    }

    @Override
    public Human next() {
        return lst.get(index++);
    }
}
