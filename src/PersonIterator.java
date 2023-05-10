import java.util.Iterator;
import java.util.List;

public class PersonIterator<Person> implements Iterator<Person> {
    private int index;
    private List<Person> familyTree;

    public PersonIterator(List<Person> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return index < familyTree.size();
    }

    @Override
    public Person next() {
        return familyTree.get(index++);
    }

}
