package FamilyTree_homework.Family;

import FamilyTree_homework.Humans.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator <T extends TreeNode> implements Iterator<T> {
    private int index;
    private List<T> List;

    public HumanIterator(List<T> List) {
        this.List = List;
    }

    @Override
    public boolean hasNext() {
        return index < List.size();
    }

    @Override
    public T next() {
        return List.get(index++);
    }
}
