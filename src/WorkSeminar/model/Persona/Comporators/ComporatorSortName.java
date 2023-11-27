package WorkSeminar.model.Persona.Comporators;

import WorkSeminar.model.Tree.TreeEtem;

import java.util.Comparator;

public class ComporatorSortName<T extends TreeEtem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
