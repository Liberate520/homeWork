package WorkSeminar.Persona;

import java.util.Iterator;
import java.util.List;

public class IteratorPerson<Persona> implements Iterator<Persona> {

    private int index;
    private List<Persona> personaList;

    public IteratorPerson(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public boolean hasNext() {
        return index < personaList.size();
    }

    @Override
    public Persona next() {
        return personaList.get(index++);
    }
}
