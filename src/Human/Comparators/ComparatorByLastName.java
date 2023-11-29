package Human.Comparators;

import Human.Human;

public class ComparatorByLastName implements HumanComparator {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
