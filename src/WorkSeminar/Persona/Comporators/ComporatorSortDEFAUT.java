package WorkSeminar.Persona.Comporators;

import WorkSeminar.Persona.Persona;

import java.util.Comparator;

public class ComporatorSortDEFAUT implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        return Integer.compare(o2.addAge(), o1.addAge());
    }
}
