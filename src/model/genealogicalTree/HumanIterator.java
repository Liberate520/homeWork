package model.genealogicalTree;

import model.genealogicalTree.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends TreeNode> implements Iterator<T> {
    private int index;
    private ArrayList<T> humanList;

    public HumanIterator(List<T> humanList){
        this.humanList = (ArrayList<T>) humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size()>index;
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }

}
