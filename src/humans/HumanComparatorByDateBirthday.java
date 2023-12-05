package humans;

import java.util.Comparator;

public class HumanComparatorByDateBirthday implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDateBirthday().compareTo(o2.getDateBirthday());
    }

    @Override
    public Comparator<Human> reversed() {
        return Comparator.super.reversed();
    }
}
