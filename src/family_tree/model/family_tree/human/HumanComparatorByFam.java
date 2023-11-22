package family_tree.model.family_tree.human;

import java.util.Comparator;

public class HumanComparatorByFam<T extends FamilyGroupItems> implements Comparator<T> {


    @Override
    public int compare(T o1, T o2) {
        return o1.getFam().compareTo(o2.getFam());
    }
}
