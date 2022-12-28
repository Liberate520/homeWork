import java.util.ArrayList;
import java.util.Iterator;

public class NewCollection implements Iterable{
    ArrayList<Object> collectionList;

    public NewCollection() {
        this.collectionList = new ArrayList<>();
    }

    public void add(Object listItem) {
        this.collectionList.add(listItem);
    }

    public ArrayList<Object> get(){
        return collectionList;
    }

    public Object get(int i){
        return collectionList.get(i);
    }

    @Override
    public Iterator<Object> iterator() {
        return new NewIterator();
    }

    class NewIterator implements Iterator<Object>{

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < collectionList.size();
        }

        @Override
        public Object next() {
            return collectionList.get(index++);
        }
    }

}