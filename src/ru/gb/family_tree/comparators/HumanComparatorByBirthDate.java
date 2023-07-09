package ru.gb.family_tree.comparators;

import java.util.Comparator;
import ru.gb.family_tree.Human;

public class HumanComparatorByBirthDate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.birthDate().compareTo(o2.birthDate());
    }
}
