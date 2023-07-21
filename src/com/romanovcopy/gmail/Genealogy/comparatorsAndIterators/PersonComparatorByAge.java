package com.romanovcopy.gmail.Genealogy.comparatorsAndIterators;

import com.romanovcopy.gmail.Genealogy.genealogyTree.Person;

import java.util.Comparator;

public class PersonComparatorByAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}
