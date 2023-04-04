package tree.comparators;
import java.util.Comparator;

import human.Human;

public class HumanComparebyChild<E extends Human> implements Comparator<E> {

    @Override
    public int compare(E h0, E h1) {
        return Integer.compare(h1.getChildren().size(), h0.getChildren().size());
    }
}
