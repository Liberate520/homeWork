package family_tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private int index;

    public FamilyTreeIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    private List<Human> humanList;

    @Override
    public boolean hasNext(){
        return index < humanList.size();
    }
    public Human next(){
        return humanList.get(index++);
    }
}
