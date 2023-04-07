package familyTree;

import person.Person;

import java.util.List;

public interface FTree<E extends Person> extends Iterable<E> {
    void addPerson(E person);

    List<E> getPersonsList();
}