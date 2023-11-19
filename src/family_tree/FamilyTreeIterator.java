package family_tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends HumanInterface<T>> implements Iterator<T> {
    private int index;

    public FamilyTreeIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    private List<T> humanList;

    @Override
    public boolean hasNext(){
        return index < humanList.size();
    }
    public T next(){
        return humanList.get(index++);
    }
}
