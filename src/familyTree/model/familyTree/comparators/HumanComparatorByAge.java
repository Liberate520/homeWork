package familyTree.model.familyTree.comparators;

import familyTree.model.familyTree.FamilyGroupItem;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamilyGroupItem<T>>
        implements Comparator<T> {
    @Override
    public int compare(T o1, T o2){
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
