package homeWork.ProjectFamilyTree.Model;

import java.util.Comparator;

public class HumanComparatorByAge<T extends Family_Tree_Item<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}
