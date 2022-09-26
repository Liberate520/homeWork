package familyTree;

import java.util.Iterator;
import HR.Human;

import java.util.Iterator;
import java.util.List;

public class humanIterator implements Iterator<Human> {
    private int index = 0;
    private List<Human> humanList;

    public humanIterator(List<Human> humanList){
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext(){
        return index < humanList.size();
    }
    @Override
    public Human next(){
        return humanList.get(index++);
    }
}
