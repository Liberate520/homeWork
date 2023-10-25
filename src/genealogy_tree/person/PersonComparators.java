package genealogy_tree.person;

import java.util.Calendar;
import java.util.Comparator;

public class PersonComparators {

    public static Comparator<Person> byAge = new Comparator<Person>() {
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
    };

    public static Comparator<Person> byFullName = new Comparator<Person>() {
        @Override
        public int compare(Person person1, Person person2) {
            String fullName1 = person1.getLastName() + person1.getFirstName() + person1.getSurName();
            String fullName2 = person2.getLastName() + person2.getFirstName() + person2.getSurName();
            return fullName1.compareTo(fullName2);
        }
    };
}
