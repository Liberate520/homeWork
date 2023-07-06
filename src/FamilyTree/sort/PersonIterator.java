package FamilyTree.sort;

import FamilyTree.tree.Person;

import java.util.Iterator;
import java.util.List;

public class PersonIterator implements Iterator <Person> {
    private int index;
    private List<Person> treeList;

    public PersonIterator(List<Person> treeList) {
        this.treeList = treeList;
    }

    @Override
    public boolean hasNext() {
        return treeList.size()> index;
    }

    @Override
    public Person next() {
        return treeList.get(index++);
    }
}
