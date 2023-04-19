package model.sorting.classes;

import java.util.Comparator;

import model.tree.classes.Human;

public class HumanComparatorByBirth<E> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(((Human) o1).getDateBirth(), ((Human) o2).getDateDeath());
    }

}
