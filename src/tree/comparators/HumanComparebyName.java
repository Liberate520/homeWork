package tree.comparators;
import java.util.Comparator;

import human.Human;

public class HumanComparebyName<E extends Human> implements Comparator<E> {

    @Override
    public int compare(E h1, E h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
