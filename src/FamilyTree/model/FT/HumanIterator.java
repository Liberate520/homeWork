package FamilyTree.model.FT;

import java.util.Iterator;
import java.util.List;

public class HumanIterator <T extends commonParam> implements Iterator<T> {
    private int index = 0;
    private final List<T> humanList;

    public HumanIterator(List<T> humanList){
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext(){
        return index < humanList.size();
    }
    @Override
    public T next(){
        return humanList.get(index++);
    }
}
