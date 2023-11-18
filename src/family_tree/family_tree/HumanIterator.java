package family_tree.family_tree;

import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator  implements Iterator<Human> {
    private  int index;
    private List<Human> humanlist;

    public HumanIterator(List<Human> humanlist){
        this.humanlist = humanlist;
    }
    @Override
    public boolean hasNext() {
        return index < humanlist.size();
    }

    @Override
    public Human next() {
        return humanlist.get(index++);
    }
}
