import java.util.Iterator;
import java.util.List;

public class FamilyIterator implements Iterator<People>{
    private int index;
    private List<People> membersList;

    public FamilyIterator(List<People> membersList) {
        this.membersList = membersList;
    }
    
    @Override
    public boolean hasNext() {
        // 
        return index < membersList.size();
    }

    @Override
    public People next() {
        // 
        return membersList.get(index++);
    }
}
