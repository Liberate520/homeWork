import java.util.Comparator;

public class FamilyComparatorByName<T extends FamilyGroup> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o2.getLastName().compareTo(o1.getLastName());
    }
}
