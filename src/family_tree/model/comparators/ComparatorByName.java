package family_tree.model.comparators;
import family_tree.model.subject.Subject;
import java.util.Comparator;

public class ComparatorByName<E extends Subject> implements Comparator<E> {
    @Override
    public int compare(E h1, E h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
