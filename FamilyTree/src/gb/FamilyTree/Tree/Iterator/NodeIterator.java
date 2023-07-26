package gb.FamilyTree.Tree.Iterator;

import java.util.Iterator;
import java.util.List;

public class NodeIterator<E> implements Iterator<E> {
    private List<E> nodes;
    private int index;

    public NodeIterator(List<E> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean hasNext() {
        return index < nodes.size();
    }

    @Override
    public E next() {
        return nodes.get(index++);
    }
}
