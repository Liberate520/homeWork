package FamilyTree.model;

import java.util.Comparator;

public class ChildComparator<T extends TreeItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getChildrens().size(), o1.getChildrens().size());
    }
}
