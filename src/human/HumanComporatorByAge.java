package human;

import java.util.Comparator;

public class HumanComporatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getYearOfBirrth(), o2.getYearOfBirrth());
    }
}
