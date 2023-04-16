package model.tree.comparators;

import model.Human.Human;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human> {
    @Override
    public int compare(Human o, Human ob) {
        return o.getName().compareTo(ob.getName());
    }
}
