package FamilyTree_homework.Family;

import FamilyTree_homework.Humans.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator <T extends TreeNode> implements Iterator<T> {
    private int index = 0;
    private List<T> humanList;

    public HumanIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }
}
