package model.treeWork;


import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> {


    private int index;
    private List<T> famTree;

    public HumanIterator(List<T> famTree) {
        this.famTree = famTree;
    }

    @Override
    public boolean hasNext() {
        return index < famTree.size();
    }

    @Override
    public T next() {
        return famTree.get(index++);
    }
}