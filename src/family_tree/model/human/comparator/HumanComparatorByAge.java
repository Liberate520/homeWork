package family_tree.model.human.comparator;

import family_tree.model.family_tree.FamilyTreeInterface;

import java.util.Comparator;

public class HumanComparatorByAge<E extends FamilyTreeInterface> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}
