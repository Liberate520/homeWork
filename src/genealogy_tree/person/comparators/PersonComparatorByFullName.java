package genealogy_tree.person.comparators;

import java.util.Comparator;

import genealogy_tree.person.Person;

public class PersonComparatorByFullName implements Comparator<Person>{
    @Override
    public int compare(Person person1, Person person2) {
        String fullName1 = person1.getLastName() + person1.getFirstName() + person1.getSurName();
        String fullName2 = person2.getLastName() + person2.getFirstName() + person2.getSurName();
        return fullName1.compareTo(fullName2);
    }
}
