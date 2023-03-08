package comparators;

import java.util.Comparator;

import main.Human;

public class ComparatorByBirthDate<T extends Human> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
