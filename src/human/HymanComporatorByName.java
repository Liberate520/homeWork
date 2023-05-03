package human;

import famalyTree.HumanItem;

import java.util.Comparator;

public class HymanComporatorByName<T extends HumanItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
