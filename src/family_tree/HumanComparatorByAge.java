package family_tree;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(o1.getBirth(),o1.getDeath()),(o2.getAge(o2.getBirth(),o2.getDeath())));
    }
}
