package human;
import java.util.Comparator;


public class HumanComparatorByBirn implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getBirn(),o2.getBirn());
    }
}
