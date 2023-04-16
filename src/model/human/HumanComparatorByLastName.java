package model.human;

import java.util.Comparator;

public class HumanComparatorByLastName<T extends Human> implements Comparator<T> {
    public int compare(T h1, T h2) {

        return h1.getLastName().compareTo(h2.getLastName());
    }
}
