package HW_3;

import java.util.Iterator;
import java.util.List;

public class FamilyIterator implements Iterator<Human> {
    private int index;
    private List<Human> list;

    public FamilyIterator(List<Human> list) {
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
