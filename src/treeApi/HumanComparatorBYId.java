package src.treeApi;

import java.util.Comparator;

public class HumanComparatorBYId<E extends Human> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
    
}
