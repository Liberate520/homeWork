import java.util.ArrayList;
import java.util.Iterator;

public class Collection<T> implements Iterable{
    private ArrayList<T> list;
    public void add(T element) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(element);
    }
    public T get(int index) {
        if (list == null)
            return null;
        else
            return list.get(index);
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < list.size();
            }
            @Override
            public T next() {
                return list.get(index++);
            }
        };
    }
}
