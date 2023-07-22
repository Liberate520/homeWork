package FamilyTree;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import Person.Person;
import Person.PersonIterator;
import Person.ComparatorPersonByName;
import Person.ComparatorPersonByBirthday;

public class FamilyTree implements Serializable, Iterable<Person> {
    private List<Person> personList;

    public FamilyTree(){
        this.personList = new LinkedList<>();
    }

    public void addPerson(Person somebody){
        this.personList.add(somebody);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Person person: personList){
            sb.append(person);
        }
        return sb.toString();
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(personList);
    }

    public void sortByName(){
        personList.sort(new ComparatorPersonByName());
    }
    public void sortByBirthday(){
        personList.sort(new ComparatorPersonByBirthday());
    }

}
