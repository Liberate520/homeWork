package Group.Comparators;

import java.util.Comparator;
import Person.Person;

public class PersonComparatorByAge implements Comparator<Person> {
    @Override
    public int compare (Person p1, Person p2){
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}