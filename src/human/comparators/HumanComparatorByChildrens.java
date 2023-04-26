package human.comparators;

import java.util.Comparator;
import human.Human;

public class HumanComparatorByChildrens implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o2.getChildrens().size(),o1.getChildrens().size());
    }

}
