import java.util.Iterator;
import java.util.List;

public class FamilyIterator implements Iterator {
    private int index;
    private List<Human> family;

    public FamilyIterator(List<Human> family) {
        this.family = family;
    }

    @Override
    public boolean hasNext() {
        return index < family.size();
    }

    @Override
    public Object next() {
        return family.get(index++);
    }
}
