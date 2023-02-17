package src;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private int index;
    private List<Human> family;

    public FamilyTreeIterator(List<Human> family) {
        this.family = family;
    }

    @Override
    public boolean hasNext() {
        return family.size() > index;
    }

    @Override
    public Human next() {
        return family.get(index++);
    }
}
