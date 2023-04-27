import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human> {
    public int compare(Human o1, Human o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
