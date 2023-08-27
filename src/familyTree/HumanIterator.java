package familyTree;

import java.util.Iterator;
import java.util.List;

// import human.Human;

public class HumanIterator<E2> implements Iterator<E2> {
    private int index;
    private List<E2> humanList;

    public HumanIterator(List<E2> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public E2 next() {
        return humanList.get(index++);
    }
}
