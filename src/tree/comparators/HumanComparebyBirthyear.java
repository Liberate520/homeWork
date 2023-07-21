package tree.comparators;
import java.util.Comparator;

import human.Human;

public class HumanComparebyBirthyear<E extends Human> implements Comparator<E> {

    @Override
    public int compare(E h0, E h1) {
        return Integer.compare(h0.getBirthyear(), h1.getBirthyear());
    }
}
