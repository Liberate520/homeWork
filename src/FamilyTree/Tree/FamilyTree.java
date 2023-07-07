package FamilyTree.Tree;



import FamilyTree.Human.Human;
import FamilyTree.Human.comparators.sortByAge;
import FamilyTree.Human.comparators.sortByName;
import FamilyTree.Human.other.Gender;
import FamilyTree.Human.other.MotFath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Human>{
    private long id;
    private List<Human> humanList = new ArrayList<>();

    public FamilyTree(long id) {
        this.id = id;
    }

    public void addHuman(Human human){
        humanList.add(human);
    }

    public void sortByAge() {
        humanList.sort(new sortByAge());
    }

    public void sortByName(){
        humanList.sort(new sortByName());
    }
    @Override
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }

}
