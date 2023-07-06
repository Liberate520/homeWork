package gb.FamilyTree.Tree.Iterator;

import java.util.Iterator;
import gb.FamilyTree.Node.RelativeNode.RelativeNode;
import java.util.List;

public class NodeIterator implements Iterator<RelativeNode> {
    private List<RelativeNode> nodes;
    private int index;

    public NodeIterator(List<RelativeNode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean hasNext() {
        return index < nodes.size();
    }

    @Override
    public RelativeNode next() {
        return nodes.get(index++);
    }
}
