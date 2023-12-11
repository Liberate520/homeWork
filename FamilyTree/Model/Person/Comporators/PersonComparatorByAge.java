package FamilyTree.FamilyTree.Model.Person.Comporators;

import FamilyTree.FamilyTree.Model.Tree.TreeItem;


import java.util.Comparator;
import java.util.Map;

public class PersonComparatorByAge<E extends TreeItem<E>> implements Comparator<Map.Entry<Integer, E>> {
    @Override
    public int compare(Map.Entry<Integer, E> o1, Map.Entry<Integer, E> o2) {
        return o1.getValue().getBirthDate().compareTo(o2.getValue().getBirthDate());
    }
}
