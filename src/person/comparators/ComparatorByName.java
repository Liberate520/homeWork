package person.comparators;

import person.Person;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person one, Person two) {
        String nameOne = one.getName() + one.getPatronymic();
        String nameTwo = two.getName() + two.getPatronymic();
        return nameOne.compareTo(nameTwo);
    }
}
