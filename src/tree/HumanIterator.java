package tree;
import java.util.Iterator;
import java.util.List;

import human.Human;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanL) {
        this.humanList = humanL;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
