package family_tree.family_tree.model;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<G extends GeneralTypeTree> implements Iterator<G> {
    private int index;
    private final List<G> humanList;

    public HumanIterator(List<G> humanList){
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public G next() {
        return humanList.get(index++);
    }
}
