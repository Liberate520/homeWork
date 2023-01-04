import java.util.Iterator;
import java.util.List;

public class FamilyIterator<T> implements Iterator<T> {

    private List<T> memberList;
    private int index;

    public FamilyIterator(List<T> memberList) {this.memberList = memberList;}

    @Override
    public boolean hasNext() {
        return index < memberList.size();
    }

    @Override
    public T next() {
        return memberList.get(index++);
    }
}
