package Human.Comparators;

import Human.Human;
import familyTree.ItemOfFamilyTree;

import java.time.LocalDate;
import java.util.Comparator;

public class ElementComparatorByAge<E extends ItemOfFamilyTree> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
