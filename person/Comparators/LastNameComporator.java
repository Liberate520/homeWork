package person.Comparators;

import person.Person;
import java.util.Comparator;

public class LastNameComporator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2){
        return o1.getLastname().compareTo(o2.getLastname());
    }
}