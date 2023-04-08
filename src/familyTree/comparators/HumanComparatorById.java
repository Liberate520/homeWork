package familyTree.comparators;

import human.Human;

import java.util.Comparator;

public class HumanComparatorById implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getHumanList().indexOf(o1), o2.getId());
    }


}
