package Human.Comparators;

import java.util.Comparator;
import family_tree.Element;

public class HumanComporatorById<E extends Element> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return (int)(o1.getId() - o2.getId());
    }
}
