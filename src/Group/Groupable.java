package Group;

import Person.Person;

/**
 * GroupInterface
 */
public interface Groupable {
    public void addPerson(Person person);

    public Person getPersonByName(String name);

    public void findPerson();

    // public Person getPerson(); 

    // public int getSize();
    }
    