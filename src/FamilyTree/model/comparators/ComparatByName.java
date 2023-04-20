package FamilyTree.model.comparators;

import java.util.Comparator;

import FamilyTree.model.nodes.Person;

public class ComparatByName implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}