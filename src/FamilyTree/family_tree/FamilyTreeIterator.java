package FamilyTree.family_tree;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FamilyTreeIterator<T> implements Iterator<T> {
    private int currentIndex;
    private final List<T> humanList;

    public FamilyTreeIterator(List<T> humanList) {
        this.humanList = humanList;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < humanList.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            return humanList.get(currentIndex++);
        } else {
            throw new NoSuchElementException();
        }
    }
}


