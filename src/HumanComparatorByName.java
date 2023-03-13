import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human>{
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFirstname().compareTo(o2.getFirstname());
    }
}