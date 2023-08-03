
import java.util.Comparator;

public class ComparatorByAge implements Comparator<Parent> {
    @Override
    public int compare(Parent o1, Parent o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}