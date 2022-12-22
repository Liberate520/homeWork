package DZ1;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {

    private int index;
    private List<Human> humansList;

    public FamilyTreeIterator(List<Human> humansList) {
        this.humansList = humansList;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return index < humansList.size();
    }

    @Override
    public Human next() {
        // TODO Auto-generated method stub
        return humansList.get(index++);
    }

}
