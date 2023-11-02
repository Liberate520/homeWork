package WorkSeminar.Persona.Comporators;

import WorkSeminar.Persona.Persona;

import java.util.Comparator;

public class ComporatorSortAge implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        return Integer.compare(o1.addAge(), o2.addAge());
    }
}
