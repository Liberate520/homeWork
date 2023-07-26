package FamilyTree.Model.sort;

import FamilyTree.Model.tree.Being;

import java.util.Comparator;

public class NameComparator <E extends Being> implements Comparator <E> {
    @Override
    public int compare(E o1, E o2) {

        return o1.getName().compareTo(o2.getName());
    }
}
