package group;
import java.util.List;

import person.Person;

/**
 * GroupInterface
 */
public interface Groupable extends Iterable{

    void addPerson(Person person);
    List<Person> getPersonList();
    Person getPersonByName(String name);
    void findPerson();
    void sortByName(); 
    void sortByAge();
    void sortById();
    void sortByGenderd();
    }
    