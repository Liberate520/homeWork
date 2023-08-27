package family_tree.FamilyTree.Person.Comparators;

import family_tree.FamilyTree.Person.Person;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
        //return o1.getInfo().compareTo(o2.getInfo());
    }
}
