import java.util.Comparator;

public class HumanComparatorByFirstName<T> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return ((Human) o1).getFirstName().compareTo(((Human) o2).getFirstName());
    }
    
}
