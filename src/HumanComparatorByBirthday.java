import java.util.Comparator;

public class HumanComparatorByBirthday implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDateBirth().compareTo(o2.getDateBirth());
    }
}
