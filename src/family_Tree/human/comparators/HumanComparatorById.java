package family_Tree.human.comparators;

import family_Tree.human.Human;

import java.util.Comparator;

public class HumanComparatorById implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
