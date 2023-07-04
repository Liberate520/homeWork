package com.romanovcopy.gmail.Genealogy.comparatorsAndIterators;

import com.romanovcopy.gmail.Genealogy.genealogyTree.Person;

import java.util.*;

public class PersonIterator implements Iterator<Person> {

    private Iterator<Person>iterator;
    private HashMap<String,Person>map;
    private ArrayList<Person>listPerson;
    public PersonIterator(HashMap<String, Person> map){
        this.map=map;
        listPerson= (ArrayList<Person>) map.values();
    }

    public void sortById(){
        listPerson.sort(new PersonComparatorById());
        iterator=listPerson.iterator();
    }
    public void sortByName(){
        listPerson.sort(new PersonComparatorByName());
        iterator=listPerson.iterator();
    }
    public void sortBySurname(){
        listPerson.sort(new PersonComparatorBySurname());
        iterator=listPerson.iterator();
    }
    public void sortByAge(){
        listPerson.sort(new PersonComparatorByAge());
        iterator=listPerson.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
    @Override
    public Person next() {
        return map.get(iterator.next());
    }
}
