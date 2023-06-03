package human.comparator;

import human.Human;

public class HumanComparatorByBirthDate extends HumanComparator {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getBirthDate().compareTo(h2.getBirthDate());
    }
}
