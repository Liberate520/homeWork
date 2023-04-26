package tree;

import java.util.Iterator;
import java.util.List;

import human.Human;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> humans;

    public HumanIterator(List<Human> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return index < humans.size();
    }

    @Override
    public Human next() {
        return humans.get(index++);
    }

}
