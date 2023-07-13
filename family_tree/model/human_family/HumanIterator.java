package family_tree.model.human_family;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends HumanItem> implements Iterator<T> {
    private int index;
    private List<T> humanList;

    public HumanIterator(List<T> humanList) {
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
