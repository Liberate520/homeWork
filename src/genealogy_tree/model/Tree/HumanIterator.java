package genealogy_tree.model.Tree;

import java.util.Iterator;
import java.util.List;


public class HumanIterator<T> implements Iterator<T> {
    private List<T> humanList;
    private int index;

    public HumanIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }


}
