package familyTree.comparators;

import person.Person;

import java.util.Comparator;

public class PersonComparatorByGender implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int result = p1.getGender().compareTo(p2.getGender());
        if (result == 0) result = p1.getFirstName().compareTo(p2.getFirstName());
        if (result == 0) result = p1.getLastName().compareTo(p2.getLastName());
        if (result == 0) {
            /*if (p1.getBornDate().after(p2.getBornDate())) {
            result = 1;
        } else if (p1.getBornDate().before(p2.getBornDate())) {
            result = -1;
        }*/
            result = p1.getBornDate().compareTo(p2.getBornDate());
        }
        return result;
    }
}