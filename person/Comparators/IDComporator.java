package person.Comparators;

import person.Person;
import java.util.Comparator;

public class IDComporator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2){
        return Integer.compare(o1.getIntId(), o2.getIntId());
    }
}