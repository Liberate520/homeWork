package familyTree.model.person;

import familyTree.model.TreeItems;

import java.util.Comparator;

public class ComparatorName<E extends TreeItems> implements Comparator<E> {

    @Override
    public int compare(E o1,E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
