import java.util.Comparator;

public class HumanComparatorByFirstName<T extends Human> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return (o1).getFirstName().compareTo((o2).getFirstName());
    }
    
}
