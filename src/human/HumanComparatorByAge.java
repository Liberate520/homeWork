package human;

import family_tree.TreeGenerality;

import java.util.Comparator;

public class HumanComparatorByAge<E extends TreeGenerality> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}
