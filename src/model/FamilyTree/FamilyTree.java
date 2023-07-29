package model.FamilyTree;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import model.Organisms.Person.Person;
import model.Organisms.Person.PersonIterator;
import model.Organisms.Person.ComparatorPersonByName;
import model.Organisms.Person.ComparatorPersonByBirthday;

public class FamilyTree<T extends Person> implements Serializable, Iterable<Person> {
    private List<T> personList;

    public FamilyTree(){
        this.personList = new LinkedList<>();
    }

    public void addPerson(T somebody){
        this.personList.add(somebody);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(T person: personList){
            sb.append(person);
        }
        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return new PersonIterator<T>(personList);
    }

    public void sortByName(){
        personList.sort(new ComparatorPersonByName<T>());
    }
    public void sortByBirthday(){
        personList.sort(new ComparatorPersonByBirthday<T>());
    }

}
