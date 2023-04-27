package familyTree.person;

import familyTree.TreeItems;

import java.util.Comparator;

public class ComparatorGender<E extends TreeItems> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getGender(), o2.getGender());
    }
}