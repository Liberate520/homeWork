import java.util.Comparator;

public class HumanComparatorByDate implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getDate(), o2.getDate());
    }

}
