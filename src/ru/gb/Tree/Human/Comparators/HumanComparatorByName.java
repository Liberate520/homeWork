package ru.gb.Tree.Human.Comparators;

import ru.gb.Tree.Human.Human;
import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human>{
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
