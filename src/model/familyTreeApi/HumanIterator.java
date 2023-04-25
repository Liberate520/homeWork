package model.familyTreeApi;
import java.util.ArrayList;
import java.util.Iterator;

public class HumanIterator<E extends Human> implements Iterator<E> {
    private int index;
    private ArrayList<E> familyTree;

    public HumanIterator(ArrayList<E> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return index < familyTree.size();
    }

    @Override
    public E next() {
        return familyTree.get(index++);
    }
}