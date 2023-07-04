package com.romanovcopy.gmail.Genealogy.comparatorsAndIterators;

import com.romanovcopy.gmail.Genealogy.genealogyTree.Person;

import java.util.Comparator;

public class PersonComparatorBySurname implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
