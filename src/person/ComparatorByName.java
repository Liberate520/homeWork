
import java.util.Comparator;

public class ComparatorByName implements Comparator<Parent> {
    @Override
    public int compare(Parent o1, Parent o2) {
        return o1.getName().compareTo(o2.getName());
    }
}