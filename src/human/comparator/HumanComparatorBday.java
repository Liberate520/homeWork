package human.comparator;

import human.Human;

import java.util.Comparator;

public class HumanComparatorBday implements Comparator<Human> {
    @Override
    public int compare(Human o1,Human  o2) {
        return o1.getbDay().compareTo(o2.getbDay());
    }

}
