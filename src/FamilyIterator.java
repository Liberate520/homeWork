import java.util.Iterator;
import java.util.List;

public class FamilyIterator<T> implements Iterator<T>{
    private int index;
    private List<T> membersList;

    public FamilyIterator(List<T> membersList) {
        this.membersList = membersList;
    }
    
    @Override
    public boolean hasNext() {
        // 
        return index < membersList.size();
    }

    @Override
    public T next() {
        // 
        return membersList.get(index++);
    }
}
