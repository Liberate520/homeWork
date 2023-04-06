package familyTree;

import person.Person;

import java.util.List;

public interface FTree extends Iterable<Person> {
    void addPerson(Person person);

    List<Person> getPersonsList();
}