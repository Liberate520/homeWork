package homeWork.human.comparators;

import java.util.Comparator;

import homeWork.FamilyTree.iterators.TreeItem;
import homeWork.human.Human;

public class HumanComparatorByName<E extends TreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}