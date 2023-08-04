package homeWork.ProjectFamilyTree.Model;

import java.util.Iterator;
import java.util.List;

public class FamilyIterator<T> implements Iterator<T> {
    private int index;
    private List<T> familyList;

    public FamilyIterator(List<T> familyList) {
        this.familyList = familyList;
    }

    @Override
    public boolean hasNext() {
        return familyList.size() > index;
    }

    @Override
    public T next() {
        return familyList.get(index++);
    }
}
