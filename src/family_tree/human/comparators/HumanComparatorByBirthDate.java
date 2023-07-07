package family_tree.human.comparators;
import java.util.Comparator;
import family_tree.human.Human;

public class HumanComparatorByBirthDate implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
    
}
