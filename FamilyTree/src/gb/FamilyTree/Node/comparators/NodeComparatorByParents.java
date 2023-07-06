package gb.FamilyTree.Node.comparators;

import java.util.Comparator;

import gb.FamilyTree.Node.RelativeNode.RelativeNode;

public class NodeComparatorByParents implements Comparator<RelativeNode> {
    @Override
    public int compare(RelativeNode node1, RelativeNode node2) {
        return Integer.compare(node2.getParents().size(), node1.getParents().size());
    }

}
