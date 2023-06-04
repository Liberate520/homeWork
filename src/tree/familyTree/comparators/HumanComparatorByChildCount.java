package tree.familyTree.comparators;

import tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByChildCount implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        return Integer.compare(human1.getChildrenList().size(), human2.getChildrenList().size());
    }

}
