package model.familyTree;

import java.util.Comparator;

class ComparatorByName<E extends commonParam> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {

        return o1.getName().compareTo(o2.getName());
    }
}
