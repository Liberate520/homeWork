package Comparators;
import lesson3.Human;
import java.util.Comparator;

public class ComparatorByName implements Comparator<Human> {

    @Override
    public int compare(Human h1, Human h2) {
        return CharSequence.compare(h1.getName(),h2.getName());
    }
}
