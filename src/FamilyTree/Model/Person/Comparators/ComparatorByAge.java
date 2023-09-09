package family_tree.FamilyTree.Model.Person.Comparators;

import family_tree.FamilyTree.Model.Person.TreeModel;

import java.util.Comparator;

public class ComparatorByAge<T extends TreeModel<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o2.getDataBirth().compareTo(o1.getDataBirth());
    }
}
