package gb.FamilyTree.Node.comparators;

import java.util.Comparator;

import gb.FamilyTree.Node.TreeNodeable;

public class NodeComparatorByName<E extends TreeNodeable<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }

}
