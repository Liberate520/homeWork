package homeWork.family_tree.model.family_tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends TreeNode> implements Iterator <E> {
    private int index;
    private List <E> humanList;

    public FamilyTreeIterator(List<E> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
}
