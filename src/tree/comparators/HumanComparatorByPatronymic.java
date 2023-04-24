package tree.comparators;

import java.util.Comparator;

import tree.Human;

public class HumanComparatorByPatronymic implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getPatronymic().compareTo(o2.getPatronymic());
    }
    
}
