package FamilyTree.Tree;

import FamilyTree.Person.Person;
import java.util.Iterator;
import java.util.List;

public class PersonIterator implements Iterator<Person> {
    private int index;
    private List<Person> personList;

    public PersonIterator(List<Person> humanList) {
        this.personList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < personList.size();
    }

    @Override
    public Person next() {
        return personList.get(index++);
    }
}
