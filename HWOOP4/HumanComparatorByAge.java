import java.util.Comparator;

public class HumanComparatorByAge<T> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return ((Human) o1).getAge().compareTo(((Human) o2).getAge());
    }
}
