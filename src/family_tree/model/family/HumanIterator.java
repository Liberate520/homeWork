package family_tree.model.family;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends TreeNode<T>> implements Iterator<T> {

    private int index = 0;
    private List<T> humanList;

    public HumanIterator(List<T> familyMembersList) {
        humanList = familyMembersList;
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
