package FamilyTree_homework.Comparator;

import FamilyTree_homework.Family.FamilyTree;
import FamilyTree_homework.Humans.Human;

import java.util.Comparator;

public class HumanComparatorByBirthday extends FamilyTree implements Comparator<Human> {
    public int compare(Human o1, Human o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
