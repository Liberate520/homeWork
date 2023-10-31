package human;

import java.time.LocalDate;
import java.util.Comparator;

public class HumanComparatorByBirthday implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthDay().compareTo(o2.getBirthDay());
    }
}
