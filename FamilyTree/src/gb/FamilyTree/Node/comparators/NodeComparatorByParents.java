package gb.FamilyTree.Node.comparators;

import java.util.Comparator;

import gb.FamilyTree.Node.TreeNodeable;

public class NodeComparatorByParents<E extends TreeNodeable<E>> implements Comparator<E> {
    @Override
    public int compare(E node1, E node2) {
        return Integer.compare(node2.getParents().size(), node1.getParents().size());
    }

}
