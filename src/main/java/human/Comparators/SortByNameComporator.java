package human.Comparators;
import tree.interfaces.TreeCreaturable;
import java.util.Comparator;

public class SortByNameComporator<E extends TreeCreaturable> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o2.getName().compareTo(o2.getName())- o1.getName().compareTo(o1.getName());
    }
}
