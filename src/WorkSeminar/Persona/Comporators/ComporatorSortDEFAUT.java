package WorkSeminar.Persona.Comporators;

import WorkSeminar.Persona.Persona;
import WorkSeminar.Tree.TreeEtem;

import java.util.Comparator;

public class ComporatorSortDEFAUT<T extends TreeEtem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.addAge(), o1.addAge());
    }
}
