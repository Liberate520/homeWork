package familyTreeModel.comparator;

import java.util.Comparator;

import familyTreeModel.Human;

public class HumanComparatorByName<T extends Human> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
