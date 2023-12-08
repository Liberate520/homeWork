package FamilyTree_homework.Humans;

import FamilyTree_homework.Family.FamilyTree;
import FamilyTree_homework.Family.TreeNode;
import FamilyTree_homework.Humans.Human;

import java.util.Comparator;

public class HumanComparatorByName <T extends TreeNode> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
