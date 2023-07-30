package genealogy_tree.Human.comparators;

import genealogy_tree.Human.Human;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human> {
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
