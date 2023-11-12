package HomeWork.familyTree.homeWork22_10_23.src.human.Comparator;

import HomeWork.familyTree.homeWork22_10_23.src.human.Human;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
