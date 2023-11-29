package FamilyTree_homework.Comparator;

import FamilyTree_homework.Family.FamilyTree;
import FamilyTree_homework.Humans.Human;

import java.util.Comparator;

public class HumanComparatorByName extends FamilyTree implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
