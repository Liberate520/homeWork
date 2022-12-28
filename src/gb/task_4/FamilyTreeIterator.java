package gb.task_4;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends LiveBeing> implements Iterator<T> {
    private int index;
    private List<T> liveBeingsList;

    public FamilyTreeIterator(List<T> aliveBeingList) {
        this.liveBeingsList = aliveBeingList;
    }

    @Override
    public boolean hasNext() {
        return index < liveBeingsList.size();
    }

    @Override
    public T next() {
        return liveBeingsList.get(index++);
    }
}
