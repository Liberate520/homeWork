package model.group.Comparators;

import java.util.Comparator;
import model.person.NodeTree;

public class PersonComparatorById<T extends NodeTree<T>> implements Comparator<T>{

    @Override
    public int compare(T p1, T p2) {
        return Integer.compare(p1.getId(), p2.getId());
    }
}