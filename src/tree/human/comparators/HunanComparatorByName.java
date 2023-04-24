package tree.human.comparators;

import java.util.Comparator;

import tree.human.Human;

public class HunanComparatorByName implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
