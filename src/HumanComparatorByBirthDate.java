import java.util.Comparator;


public class HumanComparatorByBirthDate implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare((o1.getDateOfBirth()).getYear(), (o2.getDateOfBirth()).getYear());
    }

}
