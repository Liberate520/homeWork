package HWGT;

import HWGT.comparators.PersonComparatorByBirth;
import HWGT.comparators.PersonComparatorByName;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Iterable, Serializable {

    private List<Person> listOfPersons = new ArrayList<>();
    private Person person;

    public FamilyTree(Person person){
        listOfPersons.add(person);
    }

    public FamilyTree() {
        this(null);
    }

    public Person getPerson(String name) {
        Person personForSearch = new Person();
        personForSearch = null;
        for (int i = 1; i<listOfPersons.size();i++){

            if (listOfPersons.get(i).getName().equals(name)){
                personForSearch = listOfPersons.get(i);
            }
        }
        return personForSearch ;
    }

    public void setPerson(Person person) {
        listOfPersons.add(person);
    }
    public void sortByName(){
        listOfPersons.sort(new PersonComparatorByName());
    }
    public void sortByBirth(){
        listOfPersons.sort(new PersonComparatorByBirth());
    }

    public void dellnull(){
        listOfPersons.remove(0);
    }
    @Override
    public String toString() {
        return "HWGT.FamilyTree\n" + listOfPersons;
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(listOfPersons);
    }


}
