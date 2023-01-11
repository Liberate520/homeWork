package Семинар1.homeWork;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<T> implements Iterator<T>{
    List<T> HumanList;
    private int index;
    public TreeIterator(List<T> HumanList){
        this.HumanList = HumanList;
    }
    @Override
    public boolean hasNext() {
        
        return index < HumanList.size();
    }

    @Override
    public T next() {
        
        return HumanList.get(index++);
    }
    
}
