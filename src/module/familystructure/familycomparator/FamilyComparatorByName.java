package module.familystructure.familycomparator;

import module.familystructure.FamilyGroup;

import java.util.Comparator;

public class FamilyComparatorByName<T extends FamilyGroup<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o2.getLastName().compareTo(o1.getLastName());
    }
}
