package Tree.homeWork.src.HumanGroup.Comparators;

import Tree.homeWork.src.HumanGroup.Human;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
