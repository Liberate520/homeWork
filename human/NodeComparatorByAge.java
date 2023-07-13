package homeWork_OOP_family_tree.comparatorAndIterator;

import java.util.Comparator;

public class NodeComparatorByAge<E extends Node> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {  
        return Integer.compare(o1.people.age(), o2.people.age());
        // throw new UnsupportedOperationException("Unimplemented method 'compare'");
    }
}