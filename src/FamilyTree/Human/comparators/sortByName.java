package FamilyTree.Human.comparators;

import FamilyTree.Human.Human;

import java.util.Comparator;

public class sortByName<T extends GetGroup> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
