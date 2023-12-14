package family_tree.model.family_trees.iterators;

import java.util.Iterator;
import java.util.List;

import family_tree.model.family_trees.TreeItem;


public class ProbandIterator<E extends TreeItem<E>> implements Iterator<E>{
    private int index;
    private List<E> probandList;

    public ProbandIterator(List<E> probandList){
        this.probandList = probandList;
    }
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return index < probandList.size();
    }

    @Override
    public E next() {
        // TODO Auto-generated method stub
        return probandList.get(index++);
    }


    
}
