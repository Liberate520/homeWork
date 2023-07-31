package family_tree.model.person.comparator;

import family_tree.model.familytree.FamilyTreeItem;

import java.util.Comparator;

public class PersonComparatorByChildrenReverse<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o2.getChildren().size(), o1.getChildren().size());
    }
}
