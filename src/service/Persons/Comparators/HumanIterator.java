package service.Persons.Comparators;



import java.util.ArrayList;
import java.util.Iterator;

public class HumanIterator<T> implements Iterator<T> {
    private int index;
    private ArrayList<T> familyTree;

    public HumanIterator(ArrayList<T> familyTree){
        this.familyTree = familyTree;
    }
    @Override
    public boolean hasNext() {
        return index < familyTree.size();
    }

    @Override
    public T next() {
        return familyTree.get(index++);
    }
}
