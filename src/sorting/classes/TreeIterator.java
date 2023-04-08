package sorting.classes;

import java.util.Iterator;
import java.util.List;

import tree.classes.Human;

public class TreeIterator implements Iterator<Human> {

    private int index = 0;
    private List<Human> humanList;

    public TreeIterator (List<Human> listOfHumans){
        this.humanList = listOfHumans;
    }


    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
    
}
