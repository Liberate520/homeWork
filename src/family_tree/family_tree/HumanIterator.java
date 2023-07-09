package family_tree.family_tree;
import family_tree.human.Human;

import java.util.List;
import java.util.Iterator;

public class HumanIterator implements Iterator<Human>{
    private List<Human> humanList;
    private int index = 0;

    public HumanIterator(List<Human> humanArrayList) {
        this.humanList = humanArrayList;
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
