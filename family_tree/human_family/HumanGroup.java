package family_tree.human_family;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree.humans.Human;

public class HumanGroup implements Iterable<Human>{
    private List<Human> humanList;
    
    public HumanGroup(){
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        humanList.add(human);
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName() {
    }

    public void sortByYear() {
    }
}
