package family_tree.model.comparators;
import family_tree.model.subject.Subject;
import java.util.Comparator;


public class ComparatorByAge<E extends Subject> implements Comparator<E>{
    @Override
    public int compare(E h1, E h2) {
        return h1.getAge() - h2.getAge();
    }
}
