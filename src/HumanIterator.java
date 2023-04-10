import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> tree;

    public HumanIterator(List<Human> tree) {
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