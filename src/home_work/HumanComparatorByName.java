package home_work;

import java.util.Comparator;

public class HumanComparatorByName<E extends AnimalItem> implements Comparator<E>{
    public int compare(E h1, E h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
