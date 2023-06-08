import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int counter;
    private List<E> humanList;

    public HumanIterator(List<E> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return counter < humanList.size();
    }

    @Override
    public E next() {
        return humanList.get(counter++);
    }
}
