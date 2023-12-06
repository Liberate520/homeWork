package FamalyTree;

import java.util.Iterator;
import java.util.List;

public class TIterator<T> implements Iterator<T> {
    private int index;
    private List<T> tList;

    public TIterator(List<T> tList){
        this.tList = tList;
    }

    @Override
    public boolean hasNext() {
        return index < tList.size();
    }

    @Override
    public T next() {
        return tList.get(index++);
    }
    
}
