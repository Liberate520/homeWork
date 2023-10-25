package family_tree.family_trees;

import java.util.Iterator;
import java.util.List;

import family_tree.human.Human;

public class HumanIterator implements Iterator<Human>{
    private int index;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanList){
        this.humanList = humanList;
    }
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return index < humanList.size();
    }

    @Override
    public Human next() {
        // TODO Auto-generated method stub
        return humanList.get(index++);
    }


    
}
