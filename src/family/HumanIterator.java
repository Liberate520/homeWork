package family;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> members;
    public HumanIterator(List<Human> members) {
        index = 0;
        this.members = members;
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
