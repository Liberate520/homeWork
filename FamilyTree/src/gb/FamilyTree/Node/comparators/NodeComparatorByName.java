package gb.FamilyTree.Node.comparators;

import java.util.Comparator;

import gb.FamilyTree.Node.RelativeNode.RelativeNode;

public class NodeComparatorByName implements Comparator<RelativeNode> {

    @Override
    public int compare(RelativeNode o1, RelativeNode o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }

}
