package genealogy_tree.person.comparators;

import java.util.Calendar;
import java.util.Comparator;

import genealogy_tree.person.Person;

public class PersonComparatorByAge implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        Calendar birthDate1 = person1.getBirthDate();
        Calendar birthDate2 = person2.getBirthDate();
        
        if (birthDate1.before(birthDate2)) {
            return -1;
        } else if (birthDate1.after(birthDate2)) {
            return 1;
        } else {
            return 0;
        }
    }
}
