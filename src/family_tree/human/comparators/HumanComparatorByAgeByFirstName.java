package family_tree.human.comparators;

import family_tree.family_tree.FamilyTreeItem;
import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByAgeByFirstName<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1.getAge() - o2.getAge() != 0)
            return o1.getAge() - o2.getAge();
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
