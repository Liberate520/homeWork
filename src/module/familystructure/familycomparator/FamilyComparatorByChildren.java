package module.familystructure.familycomparator;

import module.familystructure.FamilyGroup;

import java.util.Comparator;
public class FamilyComparatorByChildren<T extends FamilyGroup<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getChildren().size(), o2.getChildren().size());

    }
}
