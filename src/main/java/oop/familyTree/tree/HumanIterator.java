package oop.familyTree.tree;

import java.util.Iterator;
import java.util.Map;

public class HumanIterator<T> implements Iterator<T> {

    private Map<String, T> currentTree;
    private String key;
    private int index;

    public HumanIterator(Map<String, T> currentTree){
        this.currentTree = currentTree;
    }

    @Override
    public boolean hasNext() {
        return index < currentTree.size();
    }

    @Override
    public T next() {
        return currentTree.get(key);
    }
}