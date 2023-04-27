package model;

import model.comparators.PersonComparatorByBirthday;
import model.comparators.PersonComparatorByName;
import model.comparators.PersonIterator;
import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends Basic> implements Iterable, Serializable {

    private List<T> listOfPersons = new ArrayList<T>();

    public FamilyTree(T person){
        if (person!=null) {
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
        listOfPersons.sort(new PersonComparatorByBirthday<T>());
    }


    @Override
    public String toString() {
        return "model.FamilyTree\n" + listOfPersons;
    }

    @Override
    public Iterator<T> iterator() {
        return new PersonIterator(listOfPersons);
    }


}
