import java.util.Iterator;
import java.util.List;

public class TreeIterator implements Iterator<Human> {

    private List<Human> tree;
    private int index;

    public TreeIterator(List<Human> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        return index < tree.size();
    }

    @Override
    public Human next() {
        return tree.get(index++);
    }
}
