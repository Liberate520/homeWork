package model.comparator;
import java.util.Comparator;

import model.person.Person;

public class ComparatorById implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getPerson_id(), o2.getPerson_id());
    }

}
