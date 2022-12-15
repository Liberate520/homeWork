import java.util.Iterator;
import java.util.List;

public class TreeIterator<T> implements Iterator<T>{
    private List<T> humans;
    private int index = 0;

    public TreeIterator(List<T> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        
        return index < humans.size();
    }

    @Override
    public T next() {
        
        return humans.get(index++);
    }
    
}
