package family_tree;

import people.Person;

import java.util.List;
import java.util.Iterator;

public class PersonIterator implements Iterator<Person>{

    private int index;
    private List<Person> personList;
    public PersonIterator(List<Person> personList) {
        this.personList = personList;
    }
    
    @Override
    public boolean hasNext() {
        return personList.size() > index;
    }

    @Override
    public Person next() {
        return personList.get(index++);
    }
}
