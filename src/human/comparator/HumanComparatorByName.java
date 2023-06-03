package human.comparator;

import human.Human;

public class HumanComparatorByName extends HumanComparator {
    @Override
    public int compare(Human h1, Human h2) {
        return String.CASE_INSENSITIVE_ORDER.compare(h1.getName(), h2.getName());
    }
}
