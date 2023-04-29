package human.comparators;
import java.util.Comparator;
import tree.TreeItem;

public class HumanComparatorByAge<T extends TreeItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }

}
