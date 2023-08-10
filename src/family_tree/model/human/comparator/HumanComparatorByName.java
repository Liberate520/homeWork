package family_tree.model.human.comparator;

import family_tree.model.family_tree.FamilyTreeInterface;

import java.util.Comparator;

public class HumanComparatorByName<E extends FamilyTreeInterface> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
