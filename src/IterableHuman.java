import java.util.Iterator;
import java.util.List;

public class IterableHuman<T> implements Iterator<T> {
    private int index;
    private List<T> humanlist;

    public IterableHuman(List<T> humanlist) {
        this.humanlist = humanlist;
    }

    @Override
    public boolean hasNext() {
        return index < humanlist.size();
    }

    @Override
    public T next() {
        return humanlist.get(index++);
    }

}
