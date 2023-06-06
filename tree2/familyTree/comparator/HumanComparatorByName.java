package homeWork.tree2.familyTree.comparator;

import homeWork.tree2.human.Human;
import homeWork.tree2.human.HumanObjectInterface;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
