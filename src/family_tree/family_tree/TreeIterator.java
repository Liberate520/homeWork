package family_tree.family_tree;

import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class TreeIterator implements Iterator<Human> {
    private int index;
    private List<Human> humanList;

    public TreeIterator(List<Human> humanList){
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
