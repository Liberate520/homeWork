package family_Tree.model.familyTree;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class HumanIterator<E extends FamilyTreeItem> implements Iterator<E> {
    public int index;
    public List<E> humanList;

    public HumanIterator(List<E> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public E next() {
        return humanList.get(index);
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super E> action) {
        Iterator.super.forEachRemaining(action);
    }
}
