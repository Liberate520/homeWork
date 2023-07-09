package family_tree.model.human;

import java.util.Iterator;
import java.util.List;

public class ParentsIterator implements Iterator<Human> {

    private int index;
    private List<Human> parents;
    public ParentsIterator(List<Human> parents) {
        this.parents = parents;
    }

    @Override
    public boolean hasNext() {
        return parents.size() > index;
    }

    @Override
    public Human next() {
        return parents.get(index++);
    }
}
