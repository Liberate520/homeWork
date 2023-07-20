import java.util.Comparator;

public class HumanComparatorByName<Entity extends Entities> implements Comparator<Entity> {
    @Override
    public int compare(Entity o1, Entity o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
