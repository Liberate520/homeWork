import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Coll implements Iterable<IntArray> {
    private List<IntArray> coll = new ArrayList<>();

    public Coll() {
        this.coll = coll;
    }


    public void addArray (int size){
        IntArray newarray = new IntArray(size);
        newarray.fill();
        coll.add(newarray);
    }

    public IntArray getArray(int index) {
        return coll.get(index);
    }

    @Override
    public Iterator<IntArray> iterator() {
        return new CollIterator();
    }

    class CollIterator implements Iterator<IntArray>{
        int index = 0;
        @Override
        public boolean hasNext() {
            return index < coll.size();
        }

        @Override
        public IntArray next() {
            return coll.get(index++);
        }
    }
}
