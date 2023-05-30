package comparators;

import person.Person;

import java.util.Comparator;

public class PersonComparatorByLastname implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		return o1.getLastname().compareTo(o2.getLastname());
	}
}
