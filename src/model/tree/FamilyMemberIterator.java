package homeWork.src.model.tree;

import java.util.Iterator;
import java.util.List;

public class FamilyMemberIterator<M extends TreeItem> implements Iterator<M> {
    private int index;
    private List<M> myFamiliMembers;

    public FamilyMemberIterator(List<M> myFamiliMembers) {
        this.myFamiliMembers = myFamiliMembers;
    }

    @Override
    public boolean hasNext() {
        return index < myFamiliMembers.size();
    }

    @Override
    public M next() {
        return myFamiliMembers.get(index++);
    }
}
