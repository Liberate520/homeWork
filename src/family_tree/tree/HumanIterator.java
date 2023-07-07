package family_tree.tree;

import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> humans;

    public HumanIterator(List<Human> humans) {
        this.humans = humans;
    }
    public boolean hasNext() {
        return humans.size() > index;
    }
    public Human next() {
        return humans.get(index++);
    }
}
