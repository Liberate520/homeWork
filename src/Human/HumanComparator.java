package Human;

import java.util.Comparator;

public interface HumanComparator extends Comparator<Human> {
    public int compare(Human o1, Human o2);
}