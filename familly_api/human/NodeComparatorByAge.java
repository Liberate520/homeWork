package familly_api.human;

import java.util.Comparator;

public class NodeComparatorByAge<E extends Node> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {  
        return Integer.compare(o1.getPeople().age(), o2.getPeople().age());
    }
}