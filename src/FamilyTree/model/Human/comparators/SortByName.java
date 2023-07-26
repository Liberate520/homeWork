package FamilyTree.model.Human.comparators;

import FamilyTree.model.Human.interfacee.GetGroup;

import java.util.Comparator;

public class SortByName<T extends GetGroup> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
