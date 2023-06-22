package FamilyTree.person.comparators;

import FamilyTree.tree.TreeItem;

import java.util.Comparator;

public class PersonComparatorByAge<T extends TreeItem> implements Comparator<T> {

    @Override
    public int compare(T person1, T person2) {
        return person1.getDateOfBirth().compareTo(person2.getDateOfBirth());
    }
}
