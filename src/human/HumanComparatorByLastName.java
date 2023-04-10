package human;

import java.util.Comparator;

public class HumanComparatorByLastName implements Comparator<Human> {
    public int compare(Human h1, Human h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}
