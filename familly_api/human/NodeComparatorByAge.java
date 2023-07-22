package familly_api.human;

import java.util.Comparator;

public class NodeComparatorByAge<E extends Node> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {  
        return Integer.compare(o1.people.age(), o2.people.age());
    }
}