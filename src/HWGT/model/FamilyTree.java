package HWGT.model;

import HWGT.comparators.PersonComparatorByBirth;
import HWGT.comparators.PersonComparatorByName;
import HWGT.comparators.PersonIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends Basic> implements Iterable, Serializable {

    private List<T> listOfPersons = new ArrayList<T>();
    private T person;

    public FamilyTree(T person){
        if (person!=null){
            listOfPersons.add(person);
        }
    }

    public FamilyTree() {
        this(null);
    }

    public T getPerson(String name) {
        T personForSearch = null;
        for (int i = 0; i<listOfPersons.size();i++){
            if (listOfPersons.get(i).getName().equals(name)){
                personForSearch = listOfPersons.get(i);
            }
        }
        return personForSearch ;
    }

    public void setPerson(T person) {
        listOfPersons.add(person);
    }

    public void sortByName (){
        listOfPersons.sort(new PersonComparatorByName<T>());
    }

    public void sortByBirth (){
        listOfPersons.sort(new PersonComparatorByBirth<T>());
    }

    public void dellnull(){
        listOfPersons.remove(0);
    }



    @Override
    public String toString() {
        return "HW01.FamilyTree\n" + listOfPersons;
    }

    @Override
    public Iterator<T> iterator() {
        return new PersonIterator(listOfPersons);
    }


}
