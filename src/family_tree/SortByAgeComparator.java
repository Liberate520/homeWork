package family_tree;

import family_tree.FamilyItem;

import java.util.Comparator;

public class SortByAgeComparator<E extends FamilyItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}
