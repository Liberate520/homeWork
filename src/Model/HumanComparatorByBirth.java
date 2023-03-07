package Model;
import java.util.Comparator;

public class HumanComparatorByBirth<T extends Human> implements Comparator<T> {

    @Override
    public int compare(T h1, T h2) {
        return Integer.compare(h1.getBirth(), h2.getBirth());
    }

}
