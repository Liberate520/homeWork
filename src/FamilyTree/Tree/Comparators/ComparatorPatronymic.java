package FamilyTree.Tree.Comparators;

import FamilyTree.Tree.HumanGroup.Human.Human;
import FamilyTree.Tree.HumanGroup.HumanGroupItem;

import java.util.Comparator;

public class ComparatorPatronymic implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getPatronymic().compareTo(o2.getPatronymic());
    }
}
