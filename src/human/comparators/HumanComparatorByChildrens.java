package human.comparators;

import java.util.Comparator;
import tree.TreeItem;

public class HumanComparatorByChildrens<T extends TreeItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getChildrens().size(),o1.getChildrens().size());
    }

}
