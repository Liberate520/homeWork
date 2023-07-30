package genealogy_tree.Tree;

import genealogy_tree.Human.Human;

import java.util.Iterator;
import java.util.List;


public class HumanIterator implements Iterator<Human> {
    private List<Human> humanList;
    private int index;

    public HumanIterator(List<Human> humanList) {
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
