package Human;

import FamTree.TreeMembers;

import java.util.Comparator;

public class ComparatorAge<T extends TreeMembers<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}
