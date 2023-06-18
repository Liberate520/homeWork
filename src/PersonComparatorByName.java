import java.util.Comparator;

public class PersonComparatorByName<T extends TreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
