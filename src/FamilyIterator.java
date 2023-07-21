import java.util.Iterator;
import java.util.List;

public class FamilyIterator<T extends HumanItem> implements Iterator<T> {
    private int index;
    private List<T> familyMembers;
    
    public FamilyIterator(List<T> familyMembers) {
        this.familyMembers = familyMembers;
    }
    
    @Override
    public boolean hasNext() {
        return index < familyMembers.size();
    }

    @Override
    public T next() {
        return familyMembers.get(index++);
    }
    
}
