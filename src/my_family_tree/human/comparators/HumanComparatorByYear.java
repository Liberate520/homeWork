package my_family_tree.human.comparators;

import my_family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByYear implements Comparator<Human> {


    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getBirthDay().getYear(), o2.getBirthDay().getYear());
    }
}
