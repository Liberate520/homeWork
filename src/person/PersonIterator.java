package person;
import java.util.Iterator;
import java.util.List;

public class PersonIterator implements Iterator<Person> {

    private int index;
    private List<Person> humanList;

    public PersonIterator(List<Person> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {

        return index< humanList.size();
    }

    @Override
    public Person next() {
        return humanList.get(index++);
    }
}