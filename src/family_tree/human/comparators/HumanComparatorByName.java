package familyTree.src.family_tree.human.comparators;

import familyTree.src.family_tree.family_tree1.FamilyTreeItem;
import java.util.Comparator;
public class HumanComparatorByName<E extends FamilyTreeItem> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}