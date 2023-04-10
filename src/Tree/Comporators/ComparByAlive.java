package Tree.Comporators;
import java.util.Comparator;

import Person.Person;

public class ComparByAlive implements Comparator<Person>{
    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getAlive() == "Жив" && person2.getAlive() == "Жив" || person1.getAlive() == "Мертв" && person2.getAlive() == "Мертв" || person1.getAlive() == null && person2.getAlive() == null ) {
            return 0;
        } else if (person1.getAlive() == "Жив" && person2.getAlive() == "Мертв" || person1.getAlive() == "Жив" && person2.getAlive() == null) {
            return -1;
        }
        else{
            return 1;}
    }
}
