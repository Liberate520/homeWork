package human1;
import java.util.Comparator;

public class HumanComparatorById implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return Integer.compare(h2.getId(), h1.getId());
    }
}
