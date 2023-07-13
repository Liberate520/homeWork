package FamilyTree.Human.comparators;

import FamilyTree.Human.Human;

import java.util.Comparator;

public class sortByAge<T extends  GetGroup> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
