package model.human;

import java.util.Comparator;

public class HumanComparatorByFirstName<T extends Human> implements Comparator<T> {
    public int compare(T h1, T h2) {
        return h1.getFirstName().compareTo(h2.getFirstName());
    }
}
