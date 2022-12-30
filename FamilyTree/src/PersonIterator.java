import java.util.Iterator;
import java.util.List;

public class PersonIterator<T extends Person> implements Iterator<Person>{

    private List<T> personList;
    private int index;

    public PersonIterator(List<T> personList) {
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

