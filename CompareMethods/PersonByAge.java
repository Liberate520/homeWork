package CompareMethods;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDate;


public class PersonByAge<Person> implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getBirthDate(), p2.getBirthDate());
    }
}
