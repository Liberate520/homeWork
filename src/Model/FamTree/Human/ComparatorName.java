package Model.FamTree.Human;

import Model.FamTree.TreeMembers;

import java.util.Comparator;

public class ComparatorName<T extends TreeMembers<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
