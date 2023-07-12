package family_tree.tree;

import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class TreeIterator implements Iterator<Human> {
    private int index;
    private List<Human> family;

    public TreeIterator(List<Human> family){
        this.index = index;
        this.family = family;
    }

    @Override
    public boolean hasNext() {
        return family.size() > index;
    }

    @Override
    public Human next() {
        return family.get(index++);
    }
}
