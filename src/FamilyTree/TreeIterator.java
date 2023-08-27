package FamilyTree;

import Human.Person;

import java.util.Iterator;
import java.util.List;

public class TreeIterator implements Iterator<Person> {
    private List<Person> list;
    private int index;

    public TreeIterator(List<Person> list){
        this.list = list;
        index = 0;
    }


    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Person next() {
        return list.get(index++);
    }
}
