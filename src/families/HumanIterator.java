package families;

import essence.Essence;

import java.util.*;

public class HumanIterator<T extends Essence<T>> implements Iterator<T> {
    private int index;
    private final List<T> family;

    public HumanIterator(List<T> family) { this.family = family;}

    @Override
    public boolean hasNext() {
        return index < family.size();
    }

    @Override
    public T next() {
        return family.get(index++);
    }
}
