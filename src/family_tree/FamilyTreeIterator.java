package family_tree;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private int index = 0;
    private List<Human> list;

    public FamilyTreeIterator(List<Human> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Human next() {
        return list.get(index++);
    }
}
