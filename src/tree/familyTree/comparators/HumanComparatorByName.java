package tree.familyTree.comparators;

import tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        return human1.getName().compareTo(human2.getName());
    }
}
