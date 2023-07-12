package familytree.human.comporatop;
import familytree.human.Human;
import java.util.Comparator;


public class HumanComporatorByBirthDate implements Comparator<Human> {



    @Override
    public int compare(Human o1, Human o2){
        return o1. getDateOfBirth().compareTo(o2. getDateOfBirth());
    }

}
