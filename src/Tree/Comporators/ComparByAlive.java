package Tree.Comporators;
import java.util.Comparator;

import Tree.Person;

public class ComparByAlive<E extends Person> implements Comparator<E>{
    @Override
    public int compare(E person1, E person2) {
        if (person1.getAlive() == "Жив" && person2.getAlive() == "Жив" || person1.getAlive() == "Мертв" && person2.getAlive() == "Мертв" || person1.getAlive() == null && person2.getAlive() == null ) {
            return 0;
        } else if (person1.getAlive() == "Жив" && person2.getAlive() == "Мертв" || person1.getAlive() == "Жив" && person2.getAlive() == null) {
            return -1;
        }
        else{
            return 1;}
    }
}
