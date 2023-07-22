package Person;

import java.time.LocalDate;
import java.util.Comparator;

public class ComparatorPersonByBirthday implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getBirthDate().isBefore(o2.getBirthDate())) {
            return -1;
        } else if (o1.getBirthDate().isAfter(o2.getBirthDate())) {
            return 1;
        }return 0;
    }
}
