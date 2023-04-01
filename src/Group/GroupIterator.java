package Group;
import java.util.Iterator;
import java.util.List;

import Person.Person;

public class GroupIterator implements Iterator<Person> {
    
    private List<Person> famyliTree;
    private int index = 0;
    
    public GroupIterator(List<Person> famyliTree) {
        this.famyliTree=famyliTree;
    }

    @Override
    public boolean hasNext() {
        return index < famyliTree.size();
    }

    @Override
    public Person next() {
        return famyliTree.get(index++);
    }
}
