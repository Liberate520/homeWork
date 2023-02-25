import java.util.Iterator;
import java.util.List;

public class PersonIterator implements Iterator<Person>
{
    private int index;

    private List<Person> person;

    public PersonIterator(List<Person> person)
    {
        this.person = person;
    }

    @Override
    public boolean hasNext() {
        return person.size() > index;
    }

    @Override
    public Person next() {
        return person.get(index++);
    }
}

