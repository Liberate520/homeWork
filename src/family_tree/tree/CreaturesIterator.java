package family_tree.tree;

import java.util.Iterator;
import java.util.List;

public class CreaturesIterator<E> implements Iterator<E> {
    private int index;
    private List<E> creatures;

    public CreaturesIterator(List<E> creatures) {
        this.creatures = creatures;
    }
    public boolean hasNext() {
        return creatures.size() > index;
    }
    public E next() {
        return creatures.get(index++);
    }
}
