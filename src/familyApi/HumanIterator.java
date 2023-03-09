package familyApi;
import java.util.Iterator;
import java.util.ArrayList;

public class HumanIterator<T> implements Iterator<T> {
    private int index;
    private ArrayList<T> familyTree;

    public HumanIterator(ArrayList<T> familyTree){
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > index;
    }

    @Override
    public T next() {
        return familyTree.get(index++);
    }
    
}
