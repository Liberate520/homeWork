package familyTreeModel.comparator;

import java.util.Comparator;

import familyTreeModel.Human;

public class HumanComparatorByAge<T extends Human> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getStartDate(), o1.getStartDate());
    }

}
