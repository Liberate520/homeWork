package HW.Iterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import HW.FamilyMember;
import HW.Human;


public class FamilyIterator<T extends FamilyMember> implements Iterator<T> {
    private int index;
    private List<T> humanList;

    public FamilyIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {

        return humanList.size() > index;
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }

}
