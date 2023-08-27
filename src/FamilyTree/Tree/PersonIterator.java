package family_tree.FamilyTree.Tree;

import family_tree.FamilyTree.Person.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonIterator implements Iterator<Person> {

    private int index;
    private List<Person> familyTree;

    public PersonIterator(ArrayList<Person> tree) {
        this.familyTree = tree;
    }

    @Override
    public boolean hasNext() {
        return index < this.familyTree.size();
    }

    @Override
    public Person next() {

        return (Person) familyTree.get(index++);
    }
}
