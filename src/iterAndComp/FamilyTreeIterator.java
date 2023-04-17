package iterAndComp;

import java.util.Iterator;
import java.util.List;

import human.Human;

public class FamilyTreeIterator<E extends Human> implements Iterator<E> {
    private int index;
    private List<E> humansList;

    public FamilyTreeIterator(List<E> humansList) {
        this.humansList = humansList;
    }

    @Override
    public boolean hasNext() {
        return index<humansList.size();
    }

    @Override
    public E next() {
        return humansList.get(index++);
    }
}
