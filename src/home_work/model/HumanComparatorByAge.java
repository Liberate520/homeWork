package home_work.model;

import java.util.Comparator;

public class HumanComparatorByAge<E extends AnimalItem> implements Comparator<E>{
    public int compare(E h1, E h2) {
        return h1.getDateOfBirth().compareTo(h2.getDateOfBirth());
    }
}
