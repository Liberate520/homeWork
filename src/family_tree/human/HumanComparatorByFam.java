package family_tree.human;

import java.util.Comparator;

public class HumanComparatorByFam implements Comparator<Human> {


    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFam().compareTo(o2.getFam());
    }
}
