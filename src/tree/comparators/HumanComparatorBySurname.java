package tree.comparators;

import java.util.Comparator;

import tree.Human;

public class HumanComparatorBySurname implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
    
}
