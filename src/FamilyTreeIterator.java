package homeWork.src;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {

    private List<Human> members;
    private int index;

    public FamilyTreeIterator(List<Human> members) {
        this.members = members;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean hasNext() {
        return index < members.size();
    }

    @Override
    public Human next() {
        return members.get(index++);
    }
}
