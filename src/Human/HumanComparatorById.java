package Human;

import java.util.Comparator;

import Servis.HumanItem;

public class HumanComparatorById<T extends HumanItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }

}