package humans.comparators;

import famalyTree.FamilyTreeItems;

import java.util.Comparator;

public class ComparatorByName<T extends FamilyTreeItems> implements Comparator<T> {

    @Override
    public int compare(T h1, T h2) {
        return h1.getFirstName().compareTo(h2.getFirstName());
    }
}