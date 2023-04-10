package Tree;

import java.util.List;

import Person.Person;

public interface Tree<E> extends Iterable<E>{
    void addPerson(E person);
    List<E> getPersonList();
    boolean add(E person);
    String getInfo();
    void save(Tree<Person> familytree, String fileName);
}
