package family_tree.human.comparator;

import family_tree.family_tree.FamilyTreeInterface;
import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge<E extends FamilyTreeInterface> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}
