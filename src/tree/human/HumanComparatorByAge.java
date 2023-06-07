package tree.human;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthDate().getYear() - o2.getBirthDate().getYear();
    }
}

