package FamilyTree.model.iterators;
import java.util.Iterator;
import java.util.List;

import FamilyTree.model.nodes.Node;

public class NodeIterator <E extends Node> implements Iterator<E> {

    private int index;
    private List<E> nodeList;

    public NodeIterator(List<E> nodes) {
        nodeList = nodes;
    }

    @Override
    public boolean hasNext() {
        return index < nodeList.size();
    }

    @Override
    public E next() {
        return nodeList.get(index++);
    }
    
}
