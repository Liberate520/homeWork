package Group.Comparators;

import java.util.Comparator;
import Person.NodeTree;

public class PersonComparatorByName<T extends NodeTree<T>> implements Comparator<T>{
    @Override
    public int compare(T p1, T p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
