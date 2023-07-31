package family_tree.comparators;
import family_tree.Subject;
import java.util.Comparator;

public class ComporatorByGender<E extends Subject> implements Comparator<E> {
    @Override
    public int compare(E h1, E h2) {
        return h1.getGender().compareTo(h2.getGender());
    }
}