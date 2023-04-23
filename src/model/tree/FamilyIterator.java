package model.tree;

import java.util.Iterator;
import java.util.*;

public class FamilyIterator<T> implements Iterator<T> {
    private int generationIndex;
    private List<T> generations;

    public FamilyIterator(List<T> generations) {
        this.generations = generations;
    }

    @Override
    public boolean hasNext() {
        return generationIndex < generations.size();
    }

    @Override
    public T next() {
        return generations.get(generationIndex++);
    }
}
