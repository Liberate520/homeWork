package family_tree.model.human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T>{
    private int index;
    private List<T> familyTree;

    public HumanIterator(List<T> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > index;
    }

    @Override
    public T next() {
        return familyTree.get(index++);
    }
}
