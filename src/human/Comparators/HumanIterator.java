package human.Comparators;

import java.util.Iterator;
import java.util.List;
public class HumanIterator<T> implements Iterator<T> {
    private int index;
    private List<T> familyTree;

    public HumanIterator(List<T> familyTree){
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
