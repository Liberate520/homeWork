package FamilyTree.sort;

import FamilyTree.tree.Person;

import java.util.Comparator;

public class NameComparator <Being extends Person> implements Comparator <Being> {
    @Override
    public int compare(Being o1, Being o2) {

        return o1.getName().compareTo(o2.getName());
    }
}
