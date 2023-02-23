import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTreeIterator implements Iterator<Person> {
    private ArrayList<Person> people;
    private int index;

    public FamilyTreeIterator(ArrayList<Person> people) {
        this.people = people;
    }

    @Override
    public boolean hasNext() {
        return people.size() > index;
    }

    @Override
    public Person next() {
        return people.get(index++);
    }

    @Override
    public void remove() {

    }

}
