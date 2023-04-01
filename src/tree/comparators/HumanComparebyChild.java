package tree.comparators;
import java.util.Comparator;

import human.Human;

public class HumanComparebyChild implements Comparator<Human> {

    @Override
    public int compare(Human h0, Human h1) {
        return Integer.compare(h1.getChildren().size(), h0.getChildren().size());
    }
}
