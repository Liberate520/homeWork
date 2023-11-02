package WorkSeminar.Persona.Comporators;

import WorkSeminar.Persona.Persona;

import java.util.Comparator;

public class ComporatorSortName implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
