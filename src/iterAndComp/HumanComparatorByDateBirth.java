package iterAndComp;
import human.Human;
import java.util.Comparator;
import java.util.Date;

public class HumanComparatorByDateBirth implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDateBirth().compareTo(o2.getDateBirth());
    }
}
