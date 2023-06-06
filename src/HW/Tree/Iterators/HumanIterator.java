package HW.Tree.Iterators;

import HW.Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int id;
    private List<Human> humanInFamily;

    public HumanIterator(List<Human> humanInFamily) {
        this.humanInFamily = humanInFamily;
    }

    @Override
    public boolean hasNext() {
        return id < humanInFamily.size();
    }

    @Override
    public Human next() {
        return humanInFamily.get(id++);
    }
}
