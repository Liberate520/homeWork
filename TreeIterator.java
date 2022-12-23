package Семинар1.homeWork;

import java.util.Iterator;
import java.util.List;

public class TreeIterator implements Iterator<Human>{
    List<Human> HumanList;
    private int index;
    public TreeIterator(List<Human> HumanList){
        this.HumanList = HumanList;
    }
    @Override
    public boolean hasNext() {
        
        return index < HumanList.size();
    }

    @Override
    public Human next() {
        
        return HumanList.get(index++);
    }
    
}
