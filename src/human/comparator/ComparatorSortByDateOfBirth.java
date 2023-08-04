package human.comparator;

import family_tree.FamilyItem;
import human.Human;

import java.util.Comparator;

public class ComparatorSortByDateOfBirth<E extends FamilyItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
