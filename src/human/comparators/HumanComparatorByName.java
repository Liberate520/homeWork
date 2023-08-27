package human.comparators;

import java.util.Comparator;

import familyTree.TreeItem;
// import human.Human;

public class HumanComparatorByName<E2 extends TreeItem> implements Comparator<E2> {
    @Override
    public int compare(E2 o1, E2 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
