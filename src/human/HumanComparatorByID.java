package human;

import java.util.Comparator;

public class HumanComparatorByID<T extends Human> implements Comparator<T> {
    public int compare(T h1, T h2) {
        return Integer.compare(h1.getId(), h2.getId());
    }
}
