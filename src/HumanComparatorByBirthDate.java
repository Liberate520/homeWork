import java.util.Comparator;


public class HumanComparatorByBirthDate<Entity extends Entities> implements Comparator<Entity>{

    @Override
    public int compare(Entity o1, Entity o2) {
        return Integer.compare((o1.getDateOfBirth()).getYear(), (o2.getDateOfBirth()).getYear());
    }

}
