package family_tree.FamilyTree.Person.Comparators;

import family_tree.FamilyTree.Person.Person;
import family_tree.FamilyTree.Person.TreeModel;

import java.util.Comparator;

public class ComparatorByName<T extends TreeModel<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
        //return o1.getInfo().compareTo(o2.getInfo());
    }
}
