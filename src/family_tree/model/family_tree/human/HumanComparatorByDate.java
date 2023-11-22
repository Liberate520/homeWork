package family_tree.model.family_tree.human;

import java.util.Comparator;

public class HumanComparatorByDate<T extends FamilyGroupItems> implements Comparator<T> {


    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}
