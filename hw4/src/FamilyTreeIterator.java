import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Communication> {
    private final List<Communication> family;
    int index = 0;
    public FamilyTreeIterator(List<Communication> family) {
        this.family = family;
    }


    @Override
    public boolean hasNext() {
        return index < family.size();
    }

    @Override
    public Communication next() {
        return family.get(index++);
    }
}
