package familytree.family_tree;
import java.util.Iterator;
import java.util.List;

import familytree.human.Human;

public class HumanIterator implements Iterator<Human>{
    private int index;
    private List<Human> ListHumans;
    
    public HumanIterator (List<Human> ListHumans){
        this.ListHumans = ListHumans;

    }

    @Override
    public boolean hasNext(){

        return index < ListHumans.size();
    }

    @Override
    public Human next(){

        return ListHumans.get(index++);
    }
}
