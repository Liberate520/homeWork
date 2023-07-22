package tree;

import human.Person;

import java.util.Comparator;

public class PersonComparatorByAge implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        return o1.getDateOfBirth().getYear() - o2.getDateOfBirth().getYear();
    }
}
