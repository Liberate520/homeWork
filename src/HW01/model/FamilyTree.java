package HW01.model;

import HW01.model.auxiliary.PersonComparatorByBirth;
import HW01.model.auxiliary.PersonComparatorByName;
import HW01.model.auxiliary.PersonIterator;

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
        listOfPersons.sort(new PersonComparatorByBirth<T>());
    }


    @Override
    public String toString() {
        return "HW01.model.FamilyTree\n" + listOfPersons;
    }

    @Override
    public Iterator<T> iterator() {
        return new PersonIterator(listOfPersons);
    }


}

