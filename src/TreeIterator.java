import java.util.Iterator;
import java.util.List;

public class TreeIterator implements Iterator<Person> {
    private int index;
    private List<Person> personList;

    public TreeIterator(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public boolean hasNext() {
        return index < personList.size();
    }

    @Override
    public Person next() {
        return personList.get(index++);
    }
}
