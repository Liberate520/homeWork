import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class MyCollection implements Iterable {

    Collection classList;

    public MyCollection() {
        this.classList = new ArrayList(); // я не смог описать собственну колекцию, по этому будем на основании ArrayList
    }

    public Collection get() {
        return classList;
    }

    public Object get(int i) {
        return ((ArrayList) classList).get(i);
    }


    public void add(Object listItem) {
        this.classList.add(listItem);
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator{

        int i = 0;

        @Override
        public boolean hasNext() {
            return i < classList.size();
        }

        @Override
        public Object next() {
            return ((ArrayList) classList).get(i++);
        }
    }




}
