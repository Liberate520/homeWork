import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends Human> implements Iterator<T> {
    private int index;
    private List<T> familyTree;

    public HumanIterator(List<T> familyTree) {
        this.familyTree = familyTree;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < familyTree.size();
    }

    @Override
    public T next() {
        return familyTree.get(index++);
    }

    public void sortByName() {
        Collections.sort(familyTree);
    }

}
