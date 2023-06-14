package FamilyTree.Human;

import FamilyTree.Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> family;

    public HumanIterator(List<Human> family) {
        this.family = family;
    }

    @Override
    public boolean hasNext() {
        return index < family.size();
    }

    @Override
    public Human next() {
        return family.get(index++);
    }
}
