package model.human;

import java.util.Comparator;

public class HumanComparatorByGender<T extends Human> implements Comparator<T> {
    public int compare(T h1, T h2) {
        return h1.getGender().compareTo(h2.getGender());
    }
}
