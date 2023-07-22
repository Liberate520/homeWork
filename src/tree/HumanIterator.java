package tree;

import human.Human;
import human.Person;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator {
    private int index;
    private List<Person> humanList;

    public HumanIterator(List<Person> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public Object next() {
        return humanList.get(index++);
    }
}
