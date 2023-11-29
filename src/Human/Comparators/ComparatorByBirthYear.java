package Human.Comparators;

import Human.Human;

public class ComparatorByBirthYear implements HumanComparator {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthDate().getYear() - o2.getBirthDate().getYear();
    }
}