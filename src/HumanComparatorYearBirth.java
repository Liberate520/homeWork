import java.util.Comparator;

public class HumanComparatorYearBirth implements Comparator <Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getYearBirth(), o2.getYearBirth());
    }
}
