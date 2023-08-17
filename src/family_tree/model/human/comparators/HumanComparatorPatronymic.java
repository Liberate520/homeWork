package family_tree.model.human.comparators;

import java.util.Comparator;

import family_tree.model.tree.FamilyTreeItem;

public class HumanComparatorPatronymic<E extends FamilyTreeItem<E, K>, K> implements Comparator<E>{

    @Override
    public int compare(E o1, E o2) {
        return o1.getPatronymic().compareTo(o2.getPatronymic());
    }    
}
