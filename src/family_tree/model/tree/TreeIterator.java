package family_tree.model.tree;

import family_tree.model.human.Human;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<T extends TreeNode> implements Iterator<T> {
//    private final List<T> list;
    private int index;
    private List<Human> humanList;

    public TreeIterator(List<T> humanList){
        this.humanList= (List<Human>) humanList;
    }

//    public TreeIterator(List<T> list) {
//        this.list = list;
//        index = 0;
//    }

//    public <T> TreeIterator(Set<T> humanList, List<T> list) {
//        this.list = list;
//    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public T next() {
        return (T) humanList.get(index++);
    }
}
