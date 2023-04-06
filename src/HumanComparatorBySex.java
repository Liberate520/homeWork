import java.util.Comparator;

public class HumanComparatorBySex implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getSex().length(), o2.getSex().length());
    }
}
