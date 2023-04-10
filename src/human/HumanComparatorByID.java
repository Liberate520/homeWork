package human;

import java.util.Comparator;

public class HumanComparatorByID implements Comparator<Human> {
    public int compare(Human h1, Human h2) {
        return Integer.compare(h1.getId(), h2.getId());
    }
}
