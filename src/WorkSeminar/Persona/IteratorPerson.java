package WorkSeminar.Persona;

import java.util.Iterator;
import java.util.List;

public class IteratorPerson<E> implements Iterator<E> {

    private int index;
    private List<E> personaList;

    public IteratorPerson(List<E> personaList) {
        this.personaList = personaList;
    }

    @Override
    public boolean hasNext() {
        return index < personaList.size();
    }

    @Override
    public E next() {
        return personaList.get(index++);
    }
}
