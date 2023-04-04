import java.util.Iterator;
import java.util.Map;

class TreeIterator implements Iterator<Person> {
    Map<Integer, Person> persons_list;
    Iterator<Integer> iterator;
    int size;

    public TreeIterator(Map<Integer, Person> persons_list){
        this.persons_list = persons_list;
        this.iterator = persons_list.keySet().iterator();
        this.size = persons_list.size();
    }

    @Override
    public boolean hasNext() {
        return size > 0;
    }

    @Override
    public Person next() {
        size--;
        return persons_list.get(iterator.next());
    }

}