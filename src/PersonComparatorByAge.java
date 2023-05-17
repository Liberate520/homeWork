import java.util.Comparator;

public class PersonComparatorByAge <T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getBorn(), o2.getBorn());
    }
}
