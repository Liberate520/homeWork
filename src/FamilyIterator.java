import java.util.Iterator;
import java.util.List;

public class FamilyIterator implements Iterator<Human> {
    private int index;
    private List<Human> familyMembers;
    
    public FamilyIterator(List<Human> familyMembers) {
        this.familyMembers = familyMembers;
    }
    
    @Override
    public boolean hasNext() {
        return index < familyMembers.size();
    }

    @Override
    public Human next() {
        return familyMembers.get(index++);
    }
    
}
