import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human>{
    private int index;
    private List<Human> familyMembers;

    public HumanIterator(List<Human> familyMembers){
        this.familyMembers = familyMembers;
    }
    
    @Override
    public boolean hasNext(){
        return index < familyMembers.size();
    }

    @Override
    public Human next(){
        return familyMembers.get(index++);
    }
}
