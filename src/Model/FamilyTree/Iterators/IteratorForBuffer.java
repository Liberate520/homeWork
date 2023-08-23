package Model.FamilyTree.Iterators;

import Model.BaseCharacter.BaseCharacter;

import java.util.Iterator;
import java.util.List;

public class IteratorForBuffer<T extends BaseCharacter> implements Iterator<BaseCharacter> {
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
    public BaseCharacter next() {
        return bufferList.get(index++);
    }
}
