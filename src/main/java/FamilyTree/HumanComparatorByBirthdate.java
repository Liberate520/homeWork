package FamilyTree;

import java.time.LocalDate;
import java.util.Comparator;

public class HumanComparatorByBirthdate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthdate().compareTo(o2.getBirthdate());
    }
}
