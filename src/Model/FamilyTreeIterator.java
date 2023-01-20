package DZ1.Model;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T> implements Iterator<T> {

    private int index;
    private List<T> humansList;

    public FamilyTreeIterator(List<T> humansList) {
        this.humansList = humansList;
    }

    @Override
    public boolean hasNext() {
        return index < humansList.size();
    }

    @Override
    public T next() {
        return humansList.get(index++);
    }

}
