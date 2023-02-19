
import java.util.Comparator;

public class HumanComparatorByDate implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        return human1.getBirthdate().compareTo(human2.getBirthdate());
    } 
    
}
