package family_Tree.familyTree;

import family_Tree.human.Human;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class HumanIterator implements Iterator<Human> {
    public int index;
    public List<Human> humanList;

    public HumanIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index);
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super Human> action) {
        Iterator.super.forEachRemaining(action);
    }
}
