import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private int index;
    private List<Human> treeElements;

    public FamilyTreeIterator(List<Human> treeElements) {
        this.treeElements = treeElements;
    }

    @Override
    public boolean hasNext() {
        return index < treeElements.size();
    }

    @Override
    public Human next() {
        return treeElements.get(index++);
    }
}
