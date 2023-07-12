package tree.itrator;

import human.Human;
import tree.TreeCreaturable;

import java.util.Iterator;
import java.util.List;

public class TreeIterable<E extends TreeCreaturable<E>> implements Iterator<E> {
    private int index;
    private List<E> familyList;

    public TreeIterable(List<E> familyList){
        this.familyList = familyList;
    }
    @Override
    public boolean hasNext() {
        return index < familyList.size();
    }

    @Override
    public E next() {
        return familyList.get(index++);
    }
}
