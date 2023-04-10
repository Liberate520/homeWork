package sorting.classes;

import java.util.Comparator;

import tree.classes.Human;

public class HumanComparatorByName<E> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return ((Human) o1).getName().compareTo(((Human) o2).getName());
    }
}
