import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E>{
    private int index;
    private List<E> familyMembers;

    public HumanIterator(List<E> familyMembers){
        this.familyMembers = familyMembers;
    }
    
    @Override
    public boolean hasNext(){
        return index < familyMembers.size();
    }

    @Override
    public E next(){
        return familyMembers.get(index++);
    }
}
