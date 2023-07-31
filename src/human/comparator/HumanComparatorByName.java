package human.comparator;

import family_tree.FamilyTreeElement;

import java.util.Comparator;

public class HumanComparatorByName<E extends FamilyTreeElement> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
