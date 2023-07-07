package homeWork_OOP_family_tree.comparatorAndIterator;

import java.util.Comparator;

import homeWork_OOP_family_tree.infoHuman.Node;

public class NodeComparatorByAge implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {  
        return Integer.compare(o1.people.age(), o2.people.age());
        // throw new UnsupportedOperationException("Unimplemented method 'compare'");
    }
}