package Model;

import java.util.Iterator;
import java.util.List;

public class IteratorForBuffer<T extends HouseHold> implements Iterator<HouseHold> {
    private int index;
    private List<T> bufferList;
    public IteratorForBuffer(List<T> bufferList) {
        this.bufferList = bufferList;
    }
    @Override
    public boolean hasNext() {
        return bufferList.size() > index;
    }

    @Override
    public HouseHold next() {
        return bufferList.get(index++);
    }
}
