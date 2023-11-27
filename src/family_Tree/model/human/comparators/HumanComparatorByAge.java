package family_Tree.model.human.comparators;

import family_Tree.model.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByAge<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        String age1 = o1.getAge();
        String age2 = o2.getAge();
            if (age1.length() == age2.length()){
                return o1.getAge().compareTo(o2.getAge());
            } else if (age1.length() < age2.length()) {
                return -1;
            } else return +1;
    }
}
