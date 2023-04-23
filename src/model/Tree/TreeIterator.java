package model.Tree;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<E extends TreeInterface> implements Iterator<E> {
    private int index;
    private List<E> targariens;

    public TreeIterator(List<E> targariens){
        this.targariens = targariens;
    }

    @Override
    public boolean hasNext(){
        return index < targariens.size();
    }

    @Override
    public E next() {
        return targariens.get(index++);
    }
}
