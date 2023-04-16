package model.tree.comparators;

import model.Human.Human;

import java.util.Comparator;

public class HumanComparatorByDateOfBirth implements Comparator<Human> {
    @Override
    public int compare(Human o, Human ob) {
        return o.getBirthday().compareTo(ob.getBirthday());
    }
}
