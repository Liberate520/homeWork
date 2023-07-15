package GenerationTree.Person.Comparators;

import java.util.Comparator;

import GenerationTree.Person.Person;

public class PersonComparatorBySename implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getSename().compareTo(o2.getSename());
    }

}
