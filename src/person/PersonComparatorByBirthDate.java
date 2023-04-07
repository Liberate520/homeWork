package person;
import java.util.Comparator;


public class PersonComparatorByBirthDate implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o2.getBirthDate().compareTo(o1.getBirthDate());

    }

}
