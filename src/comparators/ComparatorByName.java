package comparators;
import model.Human;
import java.util.Comparator;

public class ComparatorByName<T extends Human> implements Comparator<T> {

    @Override
    public int compare(T h1, T h2) {
        return CharSequence.compare(h1.getName(),h2.getName());
    }
}
