package comparators;
import model.Human;
import java.util.Comparator;

public class ComparatorByBirthDate<T extends Human> implements Comparator<T> {

    @Override
    public int compare(T h1, T h2) {
        return h1.getBirthDate().compareTo(h2.getBirthDate());
    }
}