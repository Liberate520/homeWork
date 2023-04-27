package famalyTree;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<Human> {
    private int index;
    private List<E> humanList;

    public HumanIterator(List<E> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return (Human) humanList.get(index++);
    }
}
