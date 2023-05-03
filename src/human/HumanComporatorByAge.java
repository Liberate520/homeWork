package human;

import famalyTree.HumanItem;

import java.util.Comparator;

public class HumanComporatorByAge<T extends HumanItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getYearOfBirrth(), o2.getYearOfBirrth());
    }
}
