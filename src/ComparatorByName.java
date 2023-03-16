import java.util.Comparator;

public class ComparatorByName<T extends Human> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return CharSequence.compare(o1.getLastname(), o2.getLastname());
    }
}