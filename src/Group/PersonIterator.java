package Group;

import java.util.Iterator;
import java.util.List;
import Person.Person;

public class PersonIterator implements Iterator<Person> {
    
    private List<Person> group;
    private int index = 0;
    
    public PersonIterator(List<Person> group) {
        this.group=group;
    }

    @Override
    public boolean hasNext() {
        return index < group.size();
    }

    @Override
    public Person next() {
        return group.get(index++);
    }
}

